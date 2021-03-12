package com.hopex.model.response.wallet;

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
public class GetDepositWithdrawResponse {
    public int Id;

    /// <summary>
    /// 币种
    /// </summary>
    public String Asset;

    /// <summary>
    /// 交易类型(1 OTC入金，2 OTC出金，3 链上入金，4 链上出金，5 内部转账-入金，6 内部转账-出金, 7 人工入金, 8 人工出金,9
    /// 快速入金,10 快速出金)
    /// </summary>
    public int OrderType;

    /// <summary>
    /// 交易类型描述
    /// </summary>
    public String OrderTypeD;

    /// <summary>
    /// 数字货币金额
    /// </summary>
    public String Amount;

    /// <summary>
    /// 人民币金额
    /// </summary>
    public String RMBAmount;

    ///// <summary>
    ///// 手续费
    ///// </summary>
    // public String Commission ;

    /// <summary>
    /// 银行名
    /// </summary>
    public String BankName;

    /// <summary>
    /// 钱包地址
    /// </summary>
    public String Addr;

    /// <summary>
    /// 交易状态(0 进行中，1 完成，2失败）
    /// </summary>
    public int OrderStatus;

    /// <summary>
    /// 交易状态描述
    /// </summary>
    public String OrderStatusD;

    /// <summary>
    /// 创建时间
    /// </summary>
    public String CreatedTime;
}
