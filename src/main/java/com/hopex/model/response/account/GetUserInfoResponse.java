package com.hopex.model.response.account;

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
public class GetUserInfoResponse {
    /// <summary>
    /// 计价货币
    /// </summary>
    private String ConversionCurrency;

    /// <summary>
    /// 当前持仓收益率(浮动盈亏/持仓占用保证金)
    /// </summary>
    private String ProfitRate;

    /// <summary>
    /// 账户总权益估值（法币)
    /// </summary>
    private String TotalWealth;

    /// <summary>
    /// 总浮动盈亏估值（法币)
    /// </summary>
    private String FloatProfit;

    /// <summary>
    /// 持仓数
    /// </summary>
    private int Position;

    /// <summary>
    /// 活跃委托书数
    /// </summary>
    private int ActiveOrder;
}
