package com.hopex.client;

import com.hopex.constant.Options;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.response.home.GetIndexNotifyResponse;
import com.hopex.model.response.home.GetIndexStatisticsResponse;
import com.hopex.service.base.HomeClientService;

public interface HomeClient {

    /// <summary>
    /// 获取成交量
    /// </summary>
    /// <returns></returns>
    GetIndexStatisticsResponse GetIndexStatistics();

    /// <summary>
    /// 获取推送公告
    /// </summary>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    ListResultViewModel<GetIndexNotifyResponse> GetIndexNotify(int page, int limit);

    static HomeClient create(Options options) {
        return new HomeClientService(options);
    }

}
