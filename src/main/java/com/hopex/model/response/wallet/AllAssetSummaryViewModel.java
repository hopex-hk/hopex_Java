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
public class AllAssetSummaryViewModel {
    /// <summary>
    /// 计价货币
    /// </summary>
    public String ConversionCurrency;

    /// <summary>
    /// 总权益
    /// </summary>
    public String TotalWealth;

    /// <summary>
    /// 浮动盈亏
    /// </summary>
    public String FloatProfit;

    /// <summary>
    /// 总可用余额
    /// </summary>
    public String AvailableBalance;
}
