package com.hopex.model.response.trade;

import java.math.BigDecimal;

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
public class GetPositionsResponse {
    /// <summary>
    /// 允许全平
    /// </summary>
    public Boolean AllowFullClose;
    /// <summary>
    /// 合约编码
    /// </summary>
    public String ContractCode;
    /// <summary>
    /// 合约名称
    /// </summary>
    public String ContractName;
    /// <summary>
    /// 杠杆倍数
    /// </summary>
    public String Leverage;
    /// <summary>
    /// 合约价值
    /// </summary>
    public String ContractValue;
    /// <summary>
    /// 合约方向："1":正向 "2":反向
    /// </summary>
    public String ContractDirection;
    /// <summary>
    /// 合约的维持保证金率
    /// </summary>
    public String MaintMarginRate;
    /// <summary>
    /// 提取方费率
    /// </summary>
    public String TakerFee;
    /// <summary>
    /// 持仓量
    /// </summary>
    public String PositionQuantity;

    /// <summary>
    /// 持仓量
    /// </summary>
    public int PositionQuantityD;

    /// <summary>
    /// 持仓方向 1: 多仓，2：空仓, 3:单向持仓
    /// </summary>
    public int Direct;

    /// <summary>
    /// 持仓方向（持多 1 /持空 -1)
    /// </summary>
    public int PosiDirect;
    /// <summary>
    /// 持仓方向（持多/持空)
    /// </summary>
    public String PosiDirectD;
    /// <summary>
    /// 开仓均价
    /// </summary>
    public String EntryPrice;
    /// <summary>
    /// 开仓均价 BigDecimal
    /// </summary>
    public BigDecimal EntryPriceD;
    /// <summary>
    /// 持仓占用保证金
    /// </summary>
    public String PositionMargin;
    /// <summary>
    /// 持仓占用保证金 BigDecimal
    /// </summary>
    public BigDecimal PositionMarginD;
    /// <summary>
    /// 强平价格
    /// </summary>
    public String LiquidationPrice;
    /// <summary>
    /// 维持保证金
    /// </summary>
    public String MaintMargin;
    /// <summary>
    /// 浮动盈亏
    /// </summary>
    public String UnrealisedPnl;
    /// <summary>
    /// 收益率
    /// </summary>
    public String UnrealisedPnlPcnt;
    /// <summary>
    /// 合理价格
    /// </summary>
    public String FairPrice;

    /// <summary>
    /// 合理价格 BigDecimal
    /// </summary>
    public BigDecimal FairPriceD;

    /// <summary>
    /// 最新成交价
    /// </summary>
    public String LastPrice;

    /// <summary>
    /// 档长度
    /// </summary>
    public int Sequence;

    /// <summary>
    /// 用户落在第几档
    /// </summary>
    public int Rank;

    /// <summary>
    /// 最小变动价位
    /// </summary>
    public BigDecimal MinPriceMovement;

    /// <summary>
    /// 最小变动价位精度
    /// </summary>
    public int MinPriceMovementPrecision;

    /// <summary>
    /// 冻结的持仓量,等待成交的平仓订单的总量
    /// </summary>
    public String PositionQuantityFreeze;

    /// <summary>
    /// 可平数量
    /// </summary>
    public String CloseablePositionQuantity;

    /// <summary>
    /// 可平数量（格式化展示）
    /// </summary>
    public String CloseablePositionQuantityD;

    /// <summary>
    /// 是否设置追加保证金
    /// </summary>
    public Boolean IsAddMargin;

    /// <summary>
    /// 排序
    /// </summary>
    public int Sort;

    /// <summary>
    /// 判断是否存在白名单
    /// </summary>
    public Boolean IsWhitelistExist;
    /// <summary>
    /// 结算货币
    /// </summary>
    public String CloseCurrency;
}
