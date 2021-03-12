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
public class QueryLiquidationHistoryResponse {
    /// <summary>
    /// 订单id
    /// </summary>
    public long OrderId;

    public String ContractCode;

    /// <summary>
    /// 合约名称
    /// </summary>
    public String ContractName;

    /// <summary>
    /// 方向，1:卖 2买
    /// </summary>
    public String Side;

    /// <summary>
    /// 方向
    /// </summary>
    public String SideDisplay;

    /// <summary>
    /// 订单类型
    /// </summary>
    public String OrderType;

    /// <summary>
    /// 订单类型
    /// <see cref="OrderSide"/>
    /// </summary>
    public int OrderTypeVal;

    /// <summary>
    /// 1 多，2空，3单向
    /// </summary>
    public int Direct;

    /// <summary>
    /// 杠杆倍数
    /// </summary>
    public String Leverage;

    /// <summary>
    /// 数量（张）
    /// </summary>
    public String OrderQuantity;

    /// <summary>
    /// 价格
    /// </summary>
    public String OrderPrice;

    /// <summary>
    /// 平仓盈亏
    /// 小数点后4位
    /// 单位结算货币
    /// 成交数量为0时显示--
    /// </summary>
    public String ClosePosPNL;

    /// <summary>
    /// 手续费(小数点后4位)
    /// </summary>
    public String Fee;

    /// <summary>
    /// 创建时间
    /// </summary>
    public String Ctime;

    /// <summary>
    /// 时间戳(微秒)
    /// </summary>
    public long Timestamp;

    /// <summary>
    /// 1.空 2.多
    /// </summary>
    public int Direction;

    /// <summary>
    /// 空/多
    /// </summary>
    public String DirectionDisplay;

    /// <summary>
    /// 持仓占用保证金-4位小数
    /// </summary>
    public String PositionMargin;

    /// <summary>
    /// 开仓均价,合理价格精度
    /// </summary>
    public String OpenPrice;

    /// <summary>
    /// 实际强平价格 ,为0时显示--
    /// </summary>
    public String LiquidationPriceReal;

    /// <summary>
    /// 是否显示强平详情
    /// </summary>
    public Boolean ShowDetail;
}
