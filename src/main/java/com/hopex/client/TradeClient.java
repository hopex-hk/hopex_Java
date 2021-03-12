package com.hopex.client;

import java.math.BigDecimal;
import java.util.List;

import com.hopex.constant.Options;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.request.QueryConditionOrdersRequest;
import com.hopex.model.request.QueryHistoryOrdersRequest;
import com.hopex.model.request.QueryLiquidationHistoryRequest;
import com.hopex.model.response.trade.GetOpenOrdersResponse;
import com.hopex.model.response.trade.GetPositionsResponse;
import com.hopex.model.response.trade.QueryConditionOrdersResponse;
import com.hopex.model.response.trade.QueryHistoryOrdersResponse;
import com.hopex.model.response.trade.QueryLiquidationHistoryResponse;
import com.hopex.model.response.trade.QueryOrderParasResponse;
import com.hopex.service.base.TradeClientService;

public interface TradeClient {

        /// <summary>
        /// 获取活跃委托
        /// </summary>
        /// <param name="contractCode"></param>
        List<GetOpenOrdersResponse> GetOpenOrders(String contractCode);

        /// <summary>
        /// 获取持仓
        /// </summary>
        /// <returns></returns>
        List<GetPositionsResponse> GetPositions();

        /// <summary>
        /// 撤条件单
        /// </summary>
        /// <param name="contractCode"></param>
        /// <param name="taskId"></param>
        /// <returns></returns>
        Boolean CancelConditionOrder(String contractCode, long taskId);

        /// <summary>
        /// 撤单
        /// </summary>
        /// <param name="contractCode"></param>
        /// <param name="orderId"></param>
        /// <returns></returns>
        Boolean CancelOrder(String contractCode, long orderId);

        /// <summary>
        /// 下条件单
        /// </summary>
        /// <param name="contractCode"></param>
        /// <param name="side"></param>
        /// <param name="type"></param>
        /// <param name="trigPrice"></param>
        /// <param name="expectedQuantity"></param>
        /// <param name="expectedPrice"></param>
        /// <returns></returns>
        Boolean CreateConditionOrder(String contractCode, int side, String type, BigDecimal trigPrice,
                        int expectedQuantity, BigDecimal expectedPrice);

        /// <summary>
        /// 下单
        /// </summary>
        /// <param name="contractCode"></param>
        /// <param name="side"></param>
        /// <param name="orderQuantity"></param>
        /// <param name="orderPrice"></param>
        /// <returns></returns>
        Long CreateOrder(String contractCode, int side, int orderQuantity, BigDecimal orderPrice);

        /// <summary>
        /// 获取条件单
        /// </summary>
        /// <param name="param"></param>
        /// <param name="page"></param>
        /// <param name="limit"></param>
        /// <returns></returns>
        ListResultViewModel<QueryConditionOrdersResponse> QueryConditionOrders(QueryConditionOrdersRequest param,
                        int page, int limit);

        /// <summary>
        /// 获取历史委托
        /// </summary>
        /// <param name="param"></param>
        /// <param name="page"></param>
        /// <param name="limit"></param>
        /// <returns></returns>
        ListResultViewModel<QueryHistoryOrdersResponse> QueryHistoryOrders(QueryHistoryOrdersRequest param, int page,
                        int limit);

        /// <summary>
        /// 获取用户强平历史
        /// </summary>
        /// <param name="param"></param>
        /// <param name="page"></param>
        /// <param name="limit"></param>
        /// <returns></returns>
        ListResultViewModel<QueryLiquidationHistoryResponse> QueryLiquidationHistory(
                        QueryLiquidationHistoryRequest param, int page, int limit);

        /// <summary>
        /// 获取下单参数
        /// </summary>
        /// <param name="contractCode"></param>
        /// <returns></returns>
        QueryOrderParasResponse QueryOrderParas(String contractCode);

        /// <summary>
        /// 设置用户合约杠杆
        /// </summary>
        /// <param name="contractCode"></param>
        /// <param name="direct"></param>
        /// <param name="leverage"></param>
        /// <returns></returns>
        BigDecimal SetLeverage(String contractCode, int direct, BigDecimal leverage);

        static TradeClient create(Options options) {
                return new TradeClientService(options);
        }
}
