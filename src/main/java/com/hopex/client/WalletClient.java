package com.hopex.client;

import com.hopex.constant.Options;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.response.wallet.GetDepositWithdrawResponse;
import com.hopex.model.response.wallet.GetUserWalletResponse;
import com.hopex.service.base.WalletClientService;

public interface WalletClient {
    /// <summary>
    /// 获取用户出入金记录
    /// </summary>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    /// <returns></returns>
    ListResultViewModel<GetDepositWithdrawResponse> GetDepositWithdraw(int page, int limit);

    /// <summary>
    /// 获取用户资产信息
    /// </summary>
    /// <returns></returns>
    GetUserWalletResponse GetUserWallet();

    static WalletClient create(Options options) {
        return new WalletClientService(options);
    }
}
