package com.hopex.service.base;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hopex.client.MarketClient;
import com.hopex.constant.Options;
import com.hopex.model.response.market.GetKlineResponse;
import com.hopex.model.response.market.GetMarketTickerResponse;
import com.hopex.model.response.market.GetMarketsResponse;
import com.hopex.model.response.market.GetTradesResponse;
import com.hopex.model.response.market.PostQueryMarketDepthResponse;
import com.hopex.service.connection.HopexRestConnection;
import com.hopex.utils.InputChecker;
import com.hopex.utils.UrlParamsBuilder;

public class MarketClientService implements MarketClient {

    private Options options;

    private HopexRestConnection restConnection;

    public MarketClientService(Options options) {
        this.options = options;
        restConnection = new HopexRestConnection(options);
    }

    /// <summary>
    /// 获取K线
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="endTime"></param>
    /// <param name="startTime"></param>
    /// <param name="interval"></param>
    /// <returns></returns>
    @Override
    public GetKlineResponse GetKline(String contractCode, long endTime, long startTime, String interval) {
        InputChecker.checker().checkSymbol(contractCode).shouldNotNull(endTime, "endTime")
                .shouldNotNull(startTime, "startTime").shouldNotNull(interval, "interval");

        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("contractCode", contractCode);
        builder.putToUrl("endTime", endTime);
        builder.putToUrl("startTime", startTime);
        builder.putToUrl("interval", interval);

        JSONObject jsonObject = restConnection.executeGet("/api/v1/kline", builder, false);
        return jsonObject.getJSONObject("data").toJavaObject(GetKlineResponse.class);
    }

    /// <summary>
    /// 获取单个合约行情
    /// </summary>
    /// <param name="contractCode"></param>
    /// <returns></returns>
    @Override
    public GetMarketTickerResponse GetMarketTicker(String contractCode) {
        InputChecker.checker().checkSymbol(contractCode);
        JSONObject jsonObject = restConnection.executeGet("/api/v1/ticker",
                UrlParamsBuilder.build().putToUrl("contractCode", contractCode), false);
        return jsonObject.getJSONObject("data").toJavaObject(GetMarketTickerResponse.class);
    }

    /// <summary>
    /// 获取所有合约行情
    /// </summary>
    /// <returns></returns>
    @Override
    public List<GetMarketsResponse> GetMarkets() {
        JSONObject jsonObject = restConnection.executeGet("/api/v1/markets", UrlParamsBuilder.build(), false);
        return jsonObject.getJSONArray("data").toJavaList(GetMarketsResponse.class);
    }

    /// <summary>
    /// 获取最新成交
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="pageSize"></param>
    /// <returns></returns>
    @Override
    public List<GetTradesResponse> GetTrades(String contractCode, int pageSize) {
        InputChecker.checker().checkSymbol(contractCode).checkRange(pageSize, 1, 2000, "pageSize");
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("contractCode", contractCode);
        builder.putToUrl("pageSize", pageSize);

        JSONObject jsonObject = restConnection.executeGet("/api/v1/trades", builder, false);
        return jsonObject.getJSONArray("data").toJavaList(GetTradesResponse.class);
    }

    /// <summary>
    /// 获取合约深度信息
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="pageSize"></param>
    /// <returns></returns>
    @Override
    public PostQueryMarketDepthResponse PostQueryMarketDepth(String contractCode) {
        InputChecker.checker().checkSymbol(contractCode);
        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToPost("param", new HashMap<String, String>() {
            {
                put("contractCode", contractCode);
            }
        });

        JSONObject jsonObject = restConnection.executePost("/api/v1/depth", builder, false);
        return jsonObject.getJSONObject("data").toJavaObject(PostQueryMarketDepthResponse.class);
    }

}
