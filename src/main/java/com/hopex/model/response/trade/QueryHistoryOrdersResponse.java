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
public class QueryHistoryOrdersResponse {
    /// <summary>
    /// 订单ID
    /// </summary>
    public long OrderId;

    /// <summary>
    /// 合约code
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 合约name
    /// </summary>
    public String ContractName;

    /// <summary>
    /// "1":限价开仓(限价单) "2":(市价开仓)(市价单)"3": 限价全平单,"4":市价全平单 5.限价部分平仓单 6.市价部分平仓单(部分平仓)
    /// </summary>
    public String Type;

    /// <summary>
    /// 方向，1:卖 2买
    /// </summary>
    public String Side;

    /// <summary>
    /// 订单对应的持仓方向
    /// </summary>
    public int Direct;

    /// <summary>
    /// 方向
    /// </summary>
    public String SideDisplay;

    /// <summary>
    /// 创建时间
    /// </summary>
    public String Ctime;

    /// <summary>
    /// 完成时间
    /// </summary>
    public String Ftime;

    /// <summary>
    /// 数量（张）
    /// </summary>
    public String OrderQuantity;

    ///// <summary>
    ///// taker手续费
    ///// </summary>
    // public decimal TakerFee ;

    ///// <summary>
    ///// maker手续费
    ///// </summary>
    // public decimal MakerFee ;

    ///// <summary>
    ///// 还剩下多少没有成交
    ///// </summary>
    // public String LeftQuantity ;

    /// <summary>
    /// 已经成交的数量
    /// </summary>
    public String FillQuantity;

    ///// <summary>
    ///// 成交额
    ///// </summary>
    // public decimal Turnover ;

    /// <summary>
    /// 订单状态:1.部分成交 2:等待成交
    /// </summary>
    public String OrderStatus;

    /// <summary>
    /// 订单状态
    /// </summary>
    public String OrderStatusDisplay;

    /// <summary>
    /// 委托价
    /// </summary>
    public String OrderPrice;

    /// <summary>
    /// 杠杆倍数
    /// </summary>
    public String Leverage;

    /// <summary>
    /// 手续费(小数点后4位)
    /// </summary>
    public String Fee;

    /// <summary>
    /// 成交均价(指数_合理价格小数位数)
    /// </summary>
    public String AvgFillMoney;

    /// <summary>
    /// 平仓盈亏
    /// 小数点后4位
    /// 单位结算货币
    /// 成交数量为0时显示--
    /// </summary>
    public String ClosePosPNL;

    /// <summary>
    /// 时间戳(微秒)
    /// </summary>
    public long Timestamp;

    /// <summary>
    /// 订单类型
    /// <see cref="OrderSide"/>
    /// </summary>
    public int OrderTypeVal;

    /// <summary>
    /// 订单类型
    /// </summary>
    public String OrderType;

    /// <summary>
    /// 撤单原因（撤单时间自动是ftime)
    /// </summary>
    public String CancelReason;
}
