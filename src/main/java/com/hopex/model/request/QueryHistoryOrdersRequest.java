package com.hopex.model.request;

import java.util.List;

public class QueryHistoryOrdersRequest {
     /// <summary>
        /// 合约列表,为空查询所有,不为空,有几个查几个
        /// </summary>
        public List<String> ContractCodeList ;

        /// <summary>
        /// "1":限价开仓(限价单) "2":(市价开仓)(市价单)"3": 限价全平单,"4":市价全平单 5.限价部分平仓单 6.市价部分平仓单(部分平仓) 为空查所有 ,不为空有几个查几个
        /// </summary>
        public List<Integer> TypeList ;

        /// <summary>
        /// 0:no limit 1 for sell，2 for buy.
        /// </summary>
        public int Side ;

        /// <summary>
        /// 开始时间时间戳,0:代表no limit
        /// </summary>
        public long StartTime ;

        /// <summary>
        /// 结束时间时间戳,0:代表no limit
        /// </summary>
        public long EndTime ;
}
