package com.hopex.model.response.trade;

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
public class QueryOrderParasResponse {
    /// <summary>
    /// 合约编码
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 合约名称
    /// </summary>
    public String ContractName;

    /// <summary>
    /// 合约方向（正向：Forward)
    /// </summary>
    public String ContractDirect;

    /// <summary>
    /// 合约价值
    /// </summary>
    public String ContractValue;

    /// <summary>
    /// 合约价值单位
    /// </summary>
    public String ValueUnit;

    /// <summary>
    /// 结算货币
    /// </summary>
    public String CloseCurrency;

    /// <summary>
    /// take费率
    /// </summary>
    public String TakeRate;

    /// <summary>
    /// 用户是否允许交易
    /// </summary>
    public Boolean UserAllowTrade;

    /// <summary>
    /// 合约是否允许交易
    /// </summary>
    public Boolean MarketAllowTrade;

    /// <summary>
    /// 最小单位精度
    /// </summary>
    public int MinPricePrecision;

    /// <summary>
    /// 最小单位
    /// </summary>
    public String MinPriceMovement;

    /// <summary>
    /// 最小单位
    /// </summary>
    public String MinPriceMovementDisplay;

    /// <summary>
    /// 多仓维持保证金率
    /// </summary>
    public String LongMaintenanceMarginRate;

    /// <summary>
    /// 多仓维持保证金率%
    /// </summary>
    public String LongMaintenanceMarginRateDisplay;

    /// <summary>
    /// 空仓维持保证金率
    /// </summary>
    public String ShortMaintenanceMarginRate;

    /// <summary>
    /// 空仓维持保证金率%
    /// </summary>
    public String ShortMaintenanceMarginRateDisplay;

    /// <summary>
    /// 最小交易数量
    /// </summary>
    public int MinTradeNum;

    /// <summary>
    /// 最小交易数量
    /// </summary>
    public String MinTradeNumDisplay;

    /// <summary>
    /// 可用余额 （保留4位小数）
    /// </summary>
    public String AvailableBalance;

    /// <summary>
    /// 可用余额
    /// </summary>
    public String AvailableBalanceDisplay;

    /// <summary>
    /// 最高允许买价（精度：合约最小变动价位位数）
    /// </summary>
    public String MaxBuyPrice;

    /// <summary>
    /// 最低允许卖价（精度：合约最小变动价位位数)
    /// </summary>
    public String MinSellPrice;

    /// <summary>
    /// 多仓-杠杆范围-最小值
    /// </summary>
    public String LongMinLeverage;

    /// <summary>
    /// 多仓-杠杆范围-最大值
    /// </summary>
    public String LongMaxLeverage;

    /// <summary>
    /// 空仓-杠杆范围-最小值
    /// </summary>
    public String ShortMinLeverage;

    /// <summary>
    /// 空仓-杠杆范围-最大值
    /// </summary>
    public String ShortMaxLeverage;

    /// <summary>
    /// 多仓默认杠杆
    /// </summary>
    public String LongDefaultLeverage;

    /// <summary>
    /// 空仓默认杠杆
    /// </summary>
    public String ShortDefaultLeverage;

    /// <summary>
    /// 多仓杠杆
    /// </summary>
    public String LongLeverage;

    /// <summary>
    /// 空仓杠杆
    /// </summary>
    public String ShortLeverage;

    /// <summary>
    /// 买入开多保证金（保留4位小数)
    /// </summary>
    public String OpenLongMargin;

    /// <summary>
    /// 买入开多保证金（展示）
    /// </summary>
    public String OpenLongMarginDisplay;

    /// <summary>
    /// 卖出开空保证金（保留4位小数)
    /// </summary>
    public String OpenShortMargin;

    /// <summary>
    /// 卖出开空保证金（展示）
    /// </summary>
    public String OpenShortMarginDisplay;

    /// <summary>
    /// 可开多
    /// </summary>
    public long OpenLongAmount;

    /// <summary>
    /// 可开空
    /// </summary>
    public long OpenShortAmount;

    /// <summary>
    /// 可平多
    /// </summary>
    public long CloseLongAmount;

    /// <summary>
    /// 可平空
    /// </summary>
    public long CloseShortAmount;

    /// <summary>
    /// 委托价值（保留4位小数）
    /// </summary>
    public String EvaluateOrderValue;

    /// <summary>
    /// 指数/合理价格小数位数
    /// </summary>
    public int Precision;

    /// <summary>
    /// 是否设置追加保证金
    /// </summary>
    public Boolean IsAddMargin;

    /// <summary>
    /// 多仓是否设置追加保证金
    /// </summary>
    public Boolean LongIsAddMargin;

    /// <summary>
    /// 空仓是否设置追加保证金
    /// </summary>
    public Boolean ShortIsAddMargin;

    /// <summary>
    /// 多仓强平价格
    /// </summary>
    public String LongLiquidationPrice;

    /// <summary>
    /// 空仓强平价格
    /// </summary>
    public String ShortLiquidationPrice;
}
