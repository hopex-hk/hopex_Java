package com.hopex.model.response.market;

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
public class OrderBookItemViewModel {
    public BigDecimal PriceD;

    /// <summary>
    /// 价格
    /// </summary>
    public String OrderPrice;

    /// <summary>
    /// 数量
    /// </summary>
    public long OrderQuantity;

    public String OrderQuantityShow;

    /// <summary>
    /// 此价格是否有用户自己的委托
    /// </summary>
    public int Exist;
}
