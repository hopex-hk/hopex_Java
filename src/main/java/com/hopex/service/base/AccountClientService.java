package com.hopex.service.base;

import com.alibaba.fastjson.JSONObject;
import com.hopex.client.AccountClient;
import com.hopex.constant.Options;
import com.hopex.model.response.account.GetUserInfoResponse;
import com.hopex.service.connection.HopexRestConnection;
import com.hopex.utils.UrlParamsBuilder;

public class AccountClientService implements AccountClient {

    private Options options;

    private HopexRestConnection restConnection;

    public AccountClientService(Options options) {
        this.options = options;
        restConnection = new HopexRestConnection(options);
    }

    /// <summary>
    /// 获取用户信息
    /// </summary>
    @Override
    public GetUserInfoResponse GetUserInfo() {
        JSONObject jsonObject = restConnection.executeGet("/api/v1/userinfo", UrlParamsBuilder.build(), true);
        return jsonObject.getJSONObject("data").toJavaObject(GetUserInfoResponse.class);
    }

}
