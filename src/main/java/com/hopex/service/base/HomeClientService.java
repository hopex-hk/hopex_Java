package com.hopex.service.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hopex.client.HomeClient;
import com.hopex.constant.Options;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.response.home.GetIndexNotifyResponse;
import com.hopex.model.response.home.GetIndexStatisticsResponse;
import com.hopex.service.connection.HopexRestConnection;
import com.hopex.utils.InputChecker;
import com.hopex.utils.UrlParamsBuilder;

public class HomeClientService implements HomeClient {
    private Options options;

    private HopexRestConnection restConnection;

    public HomeClientService(Options options) {
        this.options = options;
        restConnection = new HopexRestConnection(options);
    }

    /// <summary>
    /// 获取推送公告
    /// </summary>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    @Override
    public ListResultViewModel<GetIndexNotifyResponse> GetIndexNotify(int page, int limit) {
        InputChecker.checker().checkRange(page, 1, 2000, "page").checkRange(limit, 1, 2000, "limit");

        JSONObject jsonObject = restConnection.executeGet("/api/v1/index_notify",
                UrlParamsBuilder.build().putToUrl("page", page).putToUrl("limit", limit), false);

        return JSONObject.parseObject(jsonObject.getJSONObject("data").toJSONString(),
                new TypeReference<ListResultViewModel<GetIndexNotifyResponse>>() {
                });
    }

    /// <summary>
    /// 获取成交量
    /// </summary>
    /// <returns></returns>
    @Override
    public GetIndexStatisticsResponse GetIndexStatistics() {
        JSONObject jsonObject = restConnection.executeGet("/api/v1/indexStat", UrlParamsBuilder.build(), false);
        return jsonObject.getJSONObject("data").toJavaObject(GetIndexStatisticsResponse.class);
    }

}
