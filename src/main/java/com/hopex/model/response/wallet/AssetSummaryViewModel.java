package com.hopex.model.response.wallet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssetSummaryViewModel {
    /// <summary>
    /// 货币
    /// </summary>
    public String AssetName;

    /// <summary>
    /// 货币logo
    /// </summary>
    public String AssetLogoUrl;

    /// <summary>
    /// 浮动盈亏
    /// </summary>
    public String FloatProfit;

    /// <summary>
    /// 浮动盈亏-法币
    /// </summary>
    public String FloatProfitLegal;

    /// <summary>
    /// 收益率 (+3.20%)
    /// </summary>
    public String ProfitRate;

    /// <summary>
    /// 总权益
    /// </summary>
    public String TotalWealth;

    /// <summary>
    /// 总收益-法币
    /// </summary>
    public String TotalWealthLegal;

    /// <summary>
    /// 总权益-解释
    /// </summary>
    public String TotalWealthInfo;

    /// <summary>
    /// 可用余额
    /// </summary>
    public String AvailableBalance;

    /// <summary>
    /// 可用余额-法币
    /// </summary>
    public String AvailableBalanceLegal;

    /// <summary>
    /// 可用余额-解释
    /// </summary>
    public String AvailableBalanceInfo;

    /// <summary>
    /// 钱包余额
    /// </summary>
    public String WalletBalance;

    /// <summary>
    /// 钱包余额-法币
    /// </summary>
    public String WalletBalanceLegal;

    /// <summary>
    /// 钱包余额-解释
    /// </summary>
    public String WalletBalanceInfo;

    /// <summary>
    /// 持仓保证金
    /// </summary>
    public String PositionMargin;

    /// <summary>
    /// 持仓保证金-法币
    /// </summary>
    public String PositionMarginLegal;

    /// <summary>
    /// 委托占用保证金
    /// </summary>
    public String DelegateMargin;

    /// <summary>
    /// 委托占用保证金-法币
    /// </summary>
    public String DelegateMarginLegal;

    /// <summary>
    /// 提现冻结保证金
    /// </summary>
    public String WithdrawFreeze;

    /// <summary>
    /// 提现冻结保证金-法币
    /// </summary>
    public String WithdrawFreezeLegal;

    /// <summary>
    /// 入金
    /// </summary>
    public String DepositAmount;
    /// <summary>
    /// 入金-法币
    /// </summary>
    public String DepositAmountLegal;
    /// <summary>
    /// 出金
    /// </summary>
    public String WithdrawAmount;
    /// <summary>
    /// 出金-法币
    /// </summary>
    public String WithdrawAmountLegal;
}
