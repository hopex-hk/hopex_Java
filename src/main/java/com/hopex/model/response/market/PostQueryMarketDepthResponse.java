package com.hopex.model.response.market;

import java.util.List;

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
public class PostQueryMarketDepthResponse {
    /// <summary>
    /// 合约编码
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 精度
    /// </summary>
    public String Decimalplace;

    /// <summary>
    /// 区间
    /// </summary>
    public List<String> Intervals;

    /// <summary>
    /// 最大卖价
    /// </summary>
    public String AsksFilter;

    /// <summary>
    /// 卖盘
    /// </summary>
    public List<OrderBookItemViewModel> Asks;

    /// <summary>
    /// 最小买价
    /// </summary>
    public String BidsFilter;

    /// <summary>
    /// 买盘
    /// </summary>
    public List<OrderBookItemViewModel> Bids;
}
