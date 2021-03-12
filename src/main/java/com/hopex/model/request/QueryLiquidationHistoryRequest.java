package com.hopex.model.request;

import java.util.List;

public class QueryLiquidationHistoryRequest {
     /// <summary>
        /// 0 for no limit，1:双向持仓之多仓 2:双向持仓之空仓 3:单向持仓之多仓 4:单向持仓之空仓
        /// </summary>
        public Integer Side ;

        /// <summary>
        /// 合约编码 ，不传表示查所有
        /// </summary>
        public List<String> ContractCodeList ;
}
