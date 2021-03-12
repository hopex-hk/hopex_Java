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
public class GetMarketTickerResponse {
  /// <summary>
  /// 合约编码
  /// </summary>
  public String ContractCode;

  /// <summary>
  /// 现货指数编码
  /// </summary>
  public String SpotIndexCode;

  /// <summary>
  /// 合理价格编码
  /// </summary>
  public String FairPriceCode;

  /// <summary>
  /// 合约名称
  /// </summary>
  public String ContractName;

  /// <summary>
  /// 结算货币
  /// </summary>
  public String CloseCurrency;

  /// <summary>
  /// 合约是否允许交易
  /// </summary>
  public Boolean AllowTrade;

  /// <summary>
  /// 是否暂停交易，暂停：true 启用: false
  /// </summary>
  public Boolean Pause;

  /// <summary>
  /// 最新价
  /// </summary>
  public String LastPrice;

  /// <summary>
  /// 最新价To USD（兼容旧版本)
  /// </summary>
  public String LastPriceToUSD;

  /// <summary>
  /// 最新价 to 法币
  /// </summary>
  public String LastPriceLegal;

  /// <summary>
  /// 24小时涨跌幅
  /// </summary>
  public String ChangePercent24;

  /// <summary>
  /// 现货指数价格
  /// </summary>
  public String MarketPrice;

  /// <summary>
  /// 现货指数价格-解释
  /// </summary>
  public String MarketPriceInfo;

  /// <summary>
  /// 合理价格
  /// </summary>
  public String FairPrice;

  /// <summary>
  /// 合理价格-解释
  /// </summary>
  public String FairePriceInfo;

  /// <summary>
  /// 24h最高
  /// </summary>
  public String Price24Max;

  /// <summary>
  /// 24h最低
  /// </summary>
  public String Price24Min;

  /// <summary>
  /// 24h交易额
  /// </summary>
  public String Amount24h;

  /// <summary>
  /// 最新价To CNY
  /// </summary>
  public String LastPriceToCNY;

  /// <summary>
  /// 24h交易量
  /// </summary>
  public String Quantity24h;

  /// <summary>
  /// 资金费率
  /// </summary>
  public String FundRate;
}
