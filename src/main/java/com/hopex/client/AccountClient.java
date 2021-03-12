package com.hopex.client;

import com.hopex.constant.Options;
import com.hopex.model.response.account.GetUserInfoResponse;
import com.hopex.service.base.AccountClientService;

public interface AccountClient {

    /// <summary>
    /// 获取用户信息
    /// </summary>
    GetUserInfoResponse GetUserInfo();

    static AccountClient create(Options options) {
        return new AccountClientService(options);
    }

}
