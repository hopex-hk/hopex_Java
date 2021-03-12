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
public class GetMarketsResponse {
    /// <summary>
    /// 合约编码
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 合约名称
    /// </summary>
    public String ContractName;

    /// <summary>
    /// 合约是否允许交易
    /// </summary>
    public Boolean AllowTrade;

    /// <summary>
    /// 有持仓
    /// </summary>
    public Boolean HasPosition;

    ///// <summary>
    ///// 持仓方向（持多 1 /持空 -1)
    ///// </summary>
    // public int PosiDirect ;

    ///// <summary>
    ///// 持仓方向（持多/持空)
    ///// </summary>
    // public String PosiDirectD ;

    /// <summary>
    /// 结算货币
    /// </summary>
    public String CloseCurrency;

    /// <summary>
    /// 标价币种
    /// </summary>
    public String QuotedCurrency;

    /// <summary>
    /// 合理价格精度
    /// </summary>
    public int Precision;

    /// <summary>
    /// 合约最小变动价格
    /// </summary>
    public BigDecimal MinPriceMovement;

    /// <summary>
    /// 价格精度
    /// </summary>
    public int PricePrecision;

    /// <summary>
    /// 最新价
    /// </summary>
    public BigDecimal LastestPrice;

    /// <summary>
    /// 24小时涨跌幅
    /// </summary>
    public BigDecimal ChangePercent24h;

    /// <summary>
    /// 24小时成交额
    /// </summary>
    public BigDecimal SumAmount24h;

    /// <summary>
    /// 24小时成交额-usdt
    /// </summary>
    public BigDecimal SumAmount24hUSDT;
    /// <summary>
    /// 合约未平仓量价值(USD)
    /// </summary>
    public String PosVauleUSD;
}
