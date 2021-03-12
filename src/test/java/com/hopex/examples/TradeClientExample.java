package com.hopex.examples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import com.hopex.client.TradeClient;
import com.hopex.constant.*;
import com.hopex.model.Enum.*;
import com.hopex.model.common.*;
import com.hopex.model.request.*;
import com.hopex.model.response.trade.*;

public class TradeClientExample {
    public static void main(String[] args) throws InterruptedException {
        String contractCode = "BTCUSDT";

        TradeClient tradeClient = TradeClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());

        System.out.println("==set long leverage==");
        System.out.println("res: " + tradeClient.SetLeverage(contractCode, Direct.Long, new BigDecimal(20)));

        // Thread.sleep(1000); // response status:429 api rate limit
        // System.out.println("==set short leverage==");
        // System.out.println("res: " + tradeClient.SetLeverage(contractCode,
        // Direct.Short, new BigDecimal(10)));

        // case Limit order
        // Buy Long
        Long limitLongOrderId = tradeClient.CreateOrder(contractCode, OrderTradeType.BuyLong, 10,
                new BigDecimal(45000));
        System.out.println("create limit buy long order done: " + limitLongOrderId);

        // Thread.sleep(1000);
        // // Sell to Close Long
        // Long limitSellLongOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.SellToCloseLong, 10,
        // new BigDecimal(60000));
        // System.out.println("create limit sell to close long order done: " +
        // limitSellLongOrderId);

        // Thread.sleep(1000);
        // // Sell Short
        // Long limitShortOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.SellShort, 10,
        // new BigDecimal(60000));
        // System.out.println("create limit buy long order done: " + limitLongOrderId);

        // Thread.sleep(1000);
        // // Sell to Close Long
        // Long limitSellShortOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.BuyToCloseShort, 10,
        // new BigDecimal(50000));
        // System.out.println("create limit sell to close long order done: " +
        // limitSellLongOrderId);

        // Thread.sleep(1000);
        // Boolean cancelRes = tradeClient.CancelOrder(contractCode, limitLongOrderId);
        // System.out.println("cancel order " + limitLongOrderId + " res: " +
        // cancelRes);

        // Thread.sleep(1000);
        // cancelRes = tradeClient.CancelOrder(contractCode, limitSellLongOrderId);
        // System.out.println("cancel order " + limitSellLongOrderId + " res: " +
        // cancelRes);

        // Thread.sleep(1000);
        // cancelRes = tradeClient.CancelOrder(contractCode, limitShortOrderId);
        // System.out.println("cancel order " + limitShortOrderId + " res: " +
        // cancelRes);

        // Thread.sleep(1000);
        // cancelRes = tradeClient.CancelOrder(contractCode, limitSellShortOrderId);
        // System.out.println("cancel order " + limitSellShortOrderId + " res: " +
        // cancelRes);

        // case Market order
        // // Buy Long
        Thread.sleep(1000);
        Long MarketLongOrderId = tradeClient.CreateOrder(contractCode, OrderTradeType.BuyLong, 10, null);
        System.out.println("create market buy long order done: " + MarketLongOrderId);

        // Thread.sleep(1000);
        // // Sell to Close Long
        // Long MarketSellLongOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.SellToCloseLong, 10, null);
        // System.out.println("create market sell to close long order done: " +
        // MarketSellLongOrderId);

        // Thread.sleep(1000);
        // // Sell Short
        // Long MarketShortOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.SellShort, 10, null);
        // System.out.println("create market buy long order done: " +
        // MarketShortOrderId);

        // Thread.sleep(1000);
        // // Sell to Close Long
        // Long MarketSellShortOrderId = tradeClient.CreateOrder(contractCode,
        // OrderTradeType.BuyToCloseShort, 10, null);
        // System.out.println("create market sell to close long order done: " +
        // MarketSellShortOrderId);

        // case condition limit order
        Boolean createLimitConditionOrderRes = tradeClient.CreateConditionOrder(contractCode, OrderTradeType.BuyLong,
                OrderType.Limit, new BigDecimal(60000), 10, new BigDecimal(48000));
        System.out.println("create condition limit order done: " + createLimitConditionOrderRes);

        // case condition market order
        Thread.sleep(1000);
        Boolean createConditionMarketOrderRes = tradeClient.CreateConditionOrder(contractCode, OrderTradeType.BuyLong,
                OrderType.Market, new BigDecimal(60000), 10, null);
        System.out.println("create condition market order done: " + createConditionMarketOrderRes);

        ListResultViewModel<QueryConditionOrdersResponse> conditionOrders = tradeClient
                .QueryConditionOrders(new QueryConditionOrdersRequest() {
                    {
                        ContractCodeList = new ArrayList<String>() {
                            {
                                add(contractCode);
                            }
                        };
                        TaskTypeList = new ArrayList<>();
                        TrigTypeList = new ArrayList<>();
                        TaskStatusList = new ArrayList<>();
                        Direct = 0;
                        Side = 0;
                        StartTime = 0;
                        EndTime = 0;
                    }
                }, 1, 10);
        Long taskId = 0l;
        Optional<QueryConditionOrdersResponse> c = conditionOrders.Result.stream().filter(x -> x.TaskStatus == 1)
                .findFirst();
        if (c.isPresent()) {
            taskId = c.get().TaskId;
        }

        tradeClient.CancelConditionOrder(contractCode, taskId);
        System.out.println("cancel condition order taskId:" + taskId + " done");

        System.out.println("get open orders: " + tradeClient.GetOpenOrders(contractCode));

        System.out.println("get positions: " + tradeClient.GetPositions());

        System.out.println("get history orders: " + tradeClient.QueryHistoryOrders(new QueryHistoryOrdersRequest() {
            {
                ContractCodeList = new ArrayList<String>() {
                    {
                        add(contractCode);
                    }
                };
                TypeList = new ArrayList<>();
                Side = 0;
                StartTime = 0;
                EndTime = 0;
            }
        }, 1, 10));

        System.out.println(
                "get liquidation history" + tradeClient.QueryLiquidationHistory(new QueryLiquidationHistoryRequest() {
                    {
                        Side = 0;
                        ContractCodeList = new ArrayList<String>() {
                            {
                                add(contractCode);
                            }
                        };
                    }
                }, 1, 10));

        System.out.println("get order paras: " + tradeClient.QueryOrderParas(contractCode));
    }
}
