package com.hopex.service.connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hopex.constant.Options;
import com.hopex.exception.HopexException;
import com.hopex.utils.ConnectionFactory;
import com.hopex.utils.HashUtil;
import com.hopex.utils.UrlParamsBuilder;

import okhttp3.Request;

public class HopexRestConnection {
    private static final String GetMethod = "GET";
    private static final String PostMethod = "POST";

    private Options options;

    private String host;

    public Options getOptions() {
        return options;
    }

    public HopexRestConnection(Options options) {
        this.options = options;
        try {
            this.host = new URL(this.options.getRestHost()).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public JSONObject executeGet(String path, UrlParamsBuilder paramsBuilder, Boolean isSign) {

        Request executeRequest = BuildRequest(GetMethod, path, paramsBuilder, isSign);

        String resp = ConnectionFactory.execute(executeRequest);
        return checkAndGetResponse(resp);
    }

    public JSONObject executePost(String path, UrlParamsBuilder paramsBuilder, Boolean isSign) {
        Request executeRequest = BuildRequest(PostMethod, path, paramsBuilder, isSign);
        String resp = ConnectionFactory.execute(executeRequest);

        return checkAndGetResponse(resp);
    }

    private Request BuildRequest(String method, String path, UrlParamsBuilder paramsBuilder, Boolean isSign) {
        Options options = this.getOptions();
        Request.Builder builder = new Request.Builder().addHeader("Content-Type", "application/json");
        String userAgent = options.getUserAgent();
        if(!(userAgent==null || userAgent.isBlank())) builder.addHeader("User-Agent", userAgent);

        String url = options.getRestHost() + path + paramsBuilder.buildUrl();

        builder.url(url);
        if (isSign) {
            String date = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", new Locale("en"))
                    .format(ZonedDateTime.now(ZoneOffset.UTC));
            String padload = method == GetMethod ? paramsBuilder.GetParamsMapJson()
                    : paramsBuilder.GetPostBodyMapJson();

            String digest = HashUtil.HmacSha256(padload, "");

            StringBuilder textToSign = new StringBuilder();
            textToSign.append(String.format("date: %s\n", date));
            textToSign.append(String.format("%s %s HTTP/1.1\n", method, path));
            textToSign.append(String.format("digest: SHA-256=%s", digest));

            String signature = HashUtil.HmacSha256(textToSign.toString(), options.getSecretKey());

            String headAuth = String.format(
                    "hmac apikey=\"%s\", algorithm=\"hmac-sha256\", headers=\"date request-line digest\", signature=\"%s\"",
                    options.getApiKey(), signature);

            builder.addHeader("Date", date);
            builder.addHeader("Digest", String.format("SHA-256=%s", digest));
            builder.addHeader("Authorization", headAuth);
        }

        return method == GetMethod ? builder.build() : builder.post(paramsBuilder.buildPostBody()).build();
    }

    private JSONObject checkAndGetResponse(String resp) {
        JSONObject json = JSON.parseObject(resp);
        try {
            if (json.containsKey("ret")) {
                int ret = json.getInteger("ret");
                if (ret != 0) {
                    String err_code = json.getString("errCode");
                    String err_msg = json.getString("errStr");
                    throw new HopexException(err_code, err_msg);
                }
            } else if (json.containsKey("message")) {
                throw new HopexException(HopexException.EXEC_ERROR, "[Executing]" + json.getString("message"));
            } else {
                throw new HopexException(HopexException.RUNTIME_ERROR,
                        "[Invoking] Status cannot be found in response.");
            }
        } catch (HopexException e) {
            throw e;
        } catch (Exception e) {
            throw new HopexException(HopexException.RUNTIME_ERROR, "[Invoking] Unexpected error: " + e.getMessage());
        }

        return json;
    }

}