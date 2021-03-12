package com.hopex.model.response.market;

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
public class KLineItemViewModel {
    /// <summary>
    /// 时间戳
    /// </summary>
    public long Time;
    /// <summary>
    /// 开市值
    /// </summary>
    public String Open;
    /// <summary>
    /// 闭市值
    /// </summary>
    public String Close;
    /// <summary>
    /// 最高价
    /// </summary>
    public String High;
    /// <summary>
    /// 最低价
    /// </summary>
    public String Low;
    /// <summary>
    /// 成交量
    /// </summary>
    public String Vol;
    /// <summary>
    /// 成交额
    /// </summary>
    public String Val;
    /// <summary>
    /// 上一笔的闭市价
    /// </summary>
    public String PrevClose;
    /// <summary>
    /// 涨跌额
    /// </summary>
    public String UpDown;
    /// <summary>
    /// 涨跌率
    /// </summary>
    public String UpDownRate;

    /// <summary>
    /// 合约方向
    /// </summary>
    public int Direct;

    /// <summary>
    /// 合约价值
    /// </summary>
    public String ContractValue;
}
