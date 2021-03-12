package com.hopex.model.response.home;

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
public class GetIndexStatisticsResponse {
        /// <summary>
        /// 未平仓合约价值(USD)
        /// </summary>
        public String PosVauleUSD;

        /// <summary>
        /// 未平仓合约价值(CNY)
        /// </summary>
        public String PosVauleCNY;

        /// <summary>
        /// 24h交易额
        /// </summary>
        public String Amount24hUSD;
        /// <summary>
        /// 24h交易额
        /// </summary>
        public String Amount24hCNY;

        /// <summary>
        /// 7day交易额
        /// </summary>
        public String Amount7dayUSD;
        /// <summary>
        /// 7day交易额
        /// </summary>
        public String Amount7dayCNY;

        /// <summary>
        /// 用户数
        /// </summary>
        public String UserCount;

        /// <summary>
        /// 总交易额
        /// </summary>
        public String DealCountUSD;
        /// <summary>
        /// 总交易额
        /// </summary>
        public String DealCountCNY;
}
