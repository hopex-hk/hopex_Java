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
public class GetOpenOrdersResponse {
    /// <summary>
    /// 订单ID
    /// </summary>
    public long OrderId;

    /// <summary>
    /// 委托类型
    /// </summary>
    public String OrderType;

    /// <summary>
    /// 订单类型
    /// <see cref="OrderSide"/>
    /// </summary>
    public int OrderTypeVal;

    /// <summary>
    /// 1 多仓，2空仓
    /// </summary>
    public int Direct;

    /// <summary>
    /// 合约code
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 合约name
    /// </summary>
    public String ContractName;

    /// <summary>
    /// //1.限价 2.市价 3.限价全平 4.市价全平
    /// </summary>
    public String Type;

    /// <summary>
    /// 方向，1:卖 2买
    /// </summary>
    public String Side;

    /// <summary>
    /// 方向
    /// </summary>
    public String SideDisplay;

    /// <summary>
    /// 创建时间
    /// </summary>
    public String Ctime;

    /// <summary>
    /// 更新时间
    /// </summary>
    public String Mtime;

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

    /// <summary>
    /// 还剩下多少没有成交
    /// </summary>
    public String LeftQuantity;

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
    /// 委托保证金(小数点后4位)
    /// </summary>
    public String OrderMargin;

    /// <summary>
    /// 过期时间
    /// </summary>
    public String ExpireTime;
}
