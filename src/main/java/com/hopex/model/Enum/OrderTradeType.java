package com.hopex.model.Enum;

public class OrderTradeType {
    /// <summary>
    /// 买入开多
    /// </summary>
    public static int BuyLong = 1;

    /// <summary>
    /// 卖出开空
    /// </summary>
    public static int SellShort = 2;

    /// <summary>
    /// 买入平空
    /// </summary>
    public static int BuyToCloseShort = 3;

    /// <summary>
    /// 卖出平多
    /// </summary>
    public static int SellToCloseLong = 4;
}
