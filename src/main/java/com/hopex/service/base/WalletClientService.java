package com.hopex.service.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hopex.client.WalletClient;
import com.hopex.constant.Options;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.response.wallet.GetDepositWithdrawResponse;
import com.hopex.model.response.wallet.GetUserWalletResponse;
import com.hopex.service.connection.HopexRestConnection;
import com.hopex.utils.InputChecker;
import com.hopex.utils.UrlParamsBuilder;

public class WalletClientService implements WalletClient {
    private Options options;

    private HopexRestConnection restConnection;

    public WalletClientService(Options options) {
        this.options = options;
        restConnection = new HopexRestConnection(options);
    }

    /// <summary>
    /// 获取用户出入金记录
    /// </summary>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    /// <returns></returns>
    @Override
    public ListResultViewModel<GetDepositWithdrawResponse> GetDepositWithdraw(int page, int limit) {

        InputChecker.checker().checkRange(page, 1, 2000, "page").checkRange(limit, 1, 2000, "limit");

        JSONObject jsonObject = restConnection.executeGet("/api/v1/account_records",
                UrlParamsBuilder.build().putToUrl("page", page).putToUrl("limit", limit), true);

        return jsonObject.getJSONObject("data")
                .toJavaObject(new TypeReference<ListResultViewModel<GetDepositWithdrawResponse>>() {
                });
    }

    /// <summary>
    /// 获取用户资产信息
    /// </summary>
    /// <returns></returns>
    @Override
    public GetUserWalletResponse GetUserWallet() {
        JSONObject jsonObject = restConnection.executeGet("/api/v1/wallet", UrlParamsBuilder.build(), true);
        return jsonObject.getJSONObject("data").toJavaObject(GetUserWalletResponse.class);
    }

}
