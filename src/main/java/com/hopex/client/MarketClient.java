package com.hopex.client;

import java.util.List;

import com.hopex.constant.Options;
import com.hopex.model.response.market.GetKlineResponse;
import com.hopex.model.response.market.GetMarketTickerResponse;
import com.hopex.model.response.market.GetMarketsResponse;
import com.hopex.model.response.market.GetTradesResponse;
import com.hopex.model.response.market.PostQueryMarketDepthResponse;
import com.hopex.service.base.MarketClientService;

public interface MarketClient {

    /// <summary>
    /// 获取K线
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="endTime"></param>
    /// <param name="startTime"></param>
    /// <param name="interval"></param>
    /// <returns></returns>
    GetKlineResponse GetKline(String contractCode, long endTime, long startTime, String interval);

    /// <summary>
    /// 获取单个合约行情
    /// </summary>
    /// <param name="contractCode"></param>
    /// <returns></returns>
    GetMarketTickerResponse GetMarketTicker(String contractCode);

    /// <summary>
    /// 获取所有合约行情
    /// </summary>
    /// <returns></returns>
    List<GetMarketsResponse> GetMarkets();

    /// <summary>
    /// 获取最新成交
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="pageSize"></param>
    /// <returns></returns>
    List<GetTradesResponse> GetTrades(String contractCode, int pageSize);

    /// <summary>
    /// 获取合约深度信息
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="pageSize"></param>
    /// <returns></returns>
    PostQueryMarketDepthResponse PostQueryMarketDepth(String contractCode);

    static MarketClient create(Options options) {
        return new MarketClientService(options);
    }
}
