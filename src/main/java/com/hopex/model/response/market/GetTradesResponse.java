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
public class GetTradesResponse {
    public long Id;
    /// <summary>
    /// 成交时间
    /// </summary>
    public String Time;
    /// <summary>
    /// 时间戳（毫秒xxx.xxx)
    /// </summary>
    public double Timestamp;
    /// <summary>
    /// 成交价格
    /// </summary>
    public String FillPrice;
    /// <summary>
    /// 成交数量
    /// </summary>
    public String FillQuantity;
    /// <summary>
    /// 方向 1 sell 2 buy
    /// </summary>
    public String Side;
}
