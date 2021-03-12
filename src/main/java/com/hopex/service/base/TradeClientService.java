package com.hopex.service.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hopex.client.TradeClient;
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
import com.hopex.service.connection.HopexRestConnection;
import com.hopex.utils.InputChecker;
import com.hopex.utils.UrlParamsBuilder;

public class TradeClientService implements TradeClient {
    private Options options;

    private HopexRestConnection restConnection;

    public TradeClientService(Options options) {
        this.options = options;
        restConnection = new HopexRestConnection(options);
    }

    /// <summary>
    /// 获取活跃委托
    /// </summary>
    /// <param name="contractCode"></param>
    @Override
    public List<GetOpenOrdersResponse> GetOpenOrders(String contractCode) {
        InputChecker.checker().checkSymbol(contractCode);

        JSONObject jsonObject = restConnection.executeGet("/api/v1/order_info",
                UrlParamsBuilder.build().putToUrl("contractCode", contractCode), true);

        return jsonObject.getJSONArray("data").toJavaList(GetOpenOrdersResponse.class);
    }

    /// <summary>
    /// 获取持仓
    /// </summary>
    /// <returns></returns>
    @Override
    public List<GetPositionsResponse> GetPositions() {
        JSONObject jsonObject = restConnection.executeGet("/api/v1/position", UrlParamsBuilder.build(), true);

        return jsonObject.getJSONArray("data").toJavaList(GetPositionsResponse.class);
    }

    /// <summary>
    /// 撤条件单
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="taskId"></param>
    /// <returns></returns>
    @Override
    public Boolean CancelConditionOrder(String contractCode, long taskId) {
        InputChecker.checker().checkSymbol(contractCode).shouldNotNull(taskId, "taskId");

        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToPost("param", new HashMap<String, Object>() {
            {
                put("contractCode", contractCode);
                put("taskId", taskId);
            }
        });

        JSONObject jsonObject = restConnection.executePost("/api/v1/cancel_condition_order", builder, true);

        return jsonObject.getBoolean("data");
    }

    /// <summary>
    /// 撤单
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="orderId"></param>
    /// <returns></returns>
    @Override
    public Boolean CancelOrder(String contractCode, long orderId) {
        InputChecker.checker().checkSymbol(contractCode).shouldNotNull(orderId, "orderId");

        JSONObject jsonObject = restConnection.executeGet("/api/v1/cancel_order",
                UrlParamsBuilder.build().putToUrl("contractCode", contractCode).putToUrl("orderId", orderId), true);

        return jsonObject.getBoolean("data");
    }

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
    @Override
    public Boolean CreateConditionOrder(String contractCode, int side, String type, BigDecimal trigPrice,
            int expectedQuantity, BigDecimal expectedPrice) {
        InputChecker.checker().checkSymbol(contractCode).checkRange(side, 1, 4, "side")
                .shouldNotNull(trigPrice, "trigPrice").shouldNotNull(expectedQuantity, "expectedQuantity");

        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToPost("param", new HashMap<String, Object>() {
            {
                put("contractCode", contractCode);
                put("side", side);
                put("type", type);
                put("trigPrice", trigPrice);
                put("expectedQuantity", expectedQuantity);
                put("expectedPrice", expectedPrice);
            }
        });
        JSONObject jsonObject = restConnection.executePost("/api/v1/condition_order", builder, true);

        return jsonObject.getBoolean("data");
    }

    /// <summary>
    /// 下单
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="side"></param>
    /// <param name="orderQuantity"></param>
    /// <param name="orderPrice"></param>
    /// <returns></returns>
    @Override
    public Long CreateOrder(String contractCode, int side, int orderQuantity, BigDecimal orderPrice) {
        InputChecker.checker().checkSymbol(contractCode).checkRange(side, 1, 4, "side").shouldNotNull(orderQuantity,
                "orderQuantity");

        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToPost("param", new HashMap<String, Object>() {
            {
                put("contractCode", contractCode);
                put("side", side);
                put("orderQuantity", orderQuantity);
                put("orderPrice", orderPrice);
            }
        });
        JSONObject jsonObject = restConnection.executePost("/api/v1/order", builder, true);

        return jsonObject.getLong("data");
    }

    /// <summary>
    /// 获取条件单
    /// </summary>
    /// <param name="param"></param>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    /// <returns></returns>
    @Override
    public ListResultViewModel<QueryConditionOrdersResponse> QueryConditionOrders(QueryConditionOrdersRequest param,
            int page, int limit) {
        InputChecker.checker().checkRange(param.Side, 0, 4, "side").checkRange(param.Direct, 0, 2, "direct")
                .checkRange(page, 1, 2000, "page").checkRange(limit, 1, 2000, "limit");

        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("page", page);
        builder.putToUrl("limit", limit);
        builder.putToPost("param", param);

        JSONObject jsonObject = restConnection.executePost("/api/v1/condition_order_info", builder, true);
        return jsonObject.getJSONObject("data")
                .toJavaObject(new TypeReference<ListResultViewModel<QueryConditionOrdersResponse>>() {
                });
    }

    /// <summary>
    /// 获取历史委托
    /// </summary>
    /// <param name="param"></param>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    /// <returns></returns>
    @Override
    public ListResultViewModel<QueryHistoryOrdersResponse> QueryHistoryOrders(QueryHistoryOrdersRequest param, int page,
            int limit) {

        InputChecker.checker().checkRange(param.Side, 0, 4, "side").checkRange(page, 1, 2000, "page").checkRange(limit,
                1, 2000, "limit");

        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("page", page);
        builder.putToUrl("limit", limit);
        builder.putToPost("param", param);
        JSONObject jsonObject = restConnection.executePost("/api/v1/order_history", builder, true);
        return jsonObject.getJSONObject("data")
                .toJavaObject(new TypeReference<ListResultViewModel<QueryHistoryOrdersResponse>>() {
                });
    }

    /// <summary>
    /// 获取用户强平历史
    /// </summary>
    /// <param name="param"></param>
    /// <param name="page"></param>
    /// <param name="limit"></param>
    /// <returns></returns>
    @Override
    public ListResultViewModel<QueryLiquidationHistoryResponse> QueryLiquidationHistory(
            QueryLiquidationHistoryRequest param, int page, int limit) {
        InputChecker.checker().checkRange(param.Side, 0, 4, "side").checkRange(page, 1, 2000, "page").checkRange(limit,
                1, 2000, "limit");

        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToUrl("page", page);
        builder.putToUrl("limit", limit);
        builder.putToPost("param", param);
        JSONObject jsonObject = restConnection.executePost("/api/v1/liquidation_history", builder, true);
        return jsonObject.getJSONObject("data")
                .toJavaObject(new TypeReference<ListResultViewModel<QueryLiquidationHistoryResponse>>() {
                });
    }

    /// <summary>
    /// 获取下单参数
    /// </summary>
    /// <param name="contractCode"></param>
    /// <returns></returns>
    @Override
    public QueryOrderParasResponse QueryOrderParas(String contractCode) {
        InputChecker.checker().checkSymbol(contractCode);

        UrlParamsBuilder builder = UrlParamsBuilder.build();

        builder.putToPost("param", new HashMap<String, Object>() {
            {
                put("contractCode", contractCode);
            }
        });
        JSONObject jsonObject = restConnection.executePost("/api/v1/get_orderParas", builder, true);

        return jsonObject.getJSONObject("data").toJavaObject(QueryOrderParasResponse.class);
    }

    /// <summary>
    /// 设置用户合约杠杆
    /// </summary>
    /// <param name="contractCode"></param>
    /// <param name="direct"></param>
    /// <param name="leverage"></param>
    /// <returns></returns>
    @Override
    public BigDecimal SetLeverage(String contractCode, int direct, BigDecimal leverage) {
        InputChecker.checker().checkSymbol(contractCode).checkRange(direct, 1, 2, "direct").checkRange(leverage,
                new BigDecimal("1.00"), new BigDecimal("100.00"), "leverage");

        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("contractCode", contractCode);
        builder.putToUrl("direct", direct);
        builder.putToUrl("leverage", leverage);

        JSONObject jsonObject = restConnection.executeGet("/api/v1/set_leverage", builder, true);
        return jsonObject.getBigDecimal("data");
    }

}
