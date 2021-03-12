package com.hopex.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.hopex.client.AccountClient;
import com.hopex.client.HomeClient;
import com.hopex.client.MarketClient;
import com.hopex.client.TradeClient;
import com.hopex.client.WalletClient;
import com.hopex.constant.Constants;
import com.hopex.constant.HopexOptions;
import com.hopex.model.Enum.CandlestickInterval;
import com.hopex.model.Enum.Direct;
import com.hopex.model.Enum.OrderTradeType;
import com.hopex.model.Enum.OrderType;
import com.hopex.model.common.ListResultViewModel;
import com.hopex.model.request.QueryConditionOrdersRequest;
import com.hopex.model.request.QueryHistoryOrdersRequest;
import com.hopex.model.request.QueryLiquidationHistoryRequest;
import com.hopex.model.response.trade.QueryConditionOrdersResponse;
import com.hopex.utils.ConnectionFactory;
import com.hopex.utils.ConnectionFactory.NetworkLatency;

/**
 * Unit test for simple App.
 */
class PerformanceTest {
    public static void main(String[] args) {

        ConnectionFactory.setLatencyDebug();
        
        System.out.println("======================================");
        testCase();
        System.out.println("======================================");

        // for (int i = 0; i < 10; i++) {
        // testCase();
        // System.out.println("======================================");
        // }

    }

    public static void testCase() {
        testHome();
        testMarket();
        testAccount();
        testTrade();
        testWallet();
    }

    public static void testHome() {
        Long startNano = null;
        Long endNano = null;
        NetworkLatency networkLatency = null;
        HomeClient homeClient = HomeClient.create(new HopexOptions());

        // /api/v1/indexStat
        startNano = System.nanoTime();
        homeClient.GetIndexStatistics();
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/index_notify
        startNano = System.nanoTime();
        homeClient.GetIndexNotify(1, 10);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);
    }

    public static void testMarket() {
        String contractCode = "BTCUSDT";
        Long startNano = null;
        Long endNano = null;
        NetworkLatency networkLatency = null;
        MarketClient marketClient = MarketClient.create(new HopexOptions());
        long endTime = (new Date().getTime()) / 1000;
        long startTime = endTime - 60 * 60 * 24;

        // /api/v1/kline
        startNano = System.nanoTime();
        marketClient.GetKline(contractCode, endTime, startTime, CandlestickInterval.HOUR1);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/ticker
        startNano = System.nanoTime();
        marketClient.GetMarketTicker(contractCode);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/markets
        startNano = System.nanoTime();
        marketClient.GetMarkets();
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/trades
        startNano = System.nanoTime();
        marketClient.GetTrades(contractCode, 10);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/depth
        startNano = System.nanoTime();
        marketClient.PostQueryMarketDepth(contractCode);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);
    }

    public static void testAccount() {
        Long startNano = null;
        Long endNano = null;
        NetworkLatency networkLatency = null;
        AccountClient accountClient = AccountClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());

        // /api/v1/userinfo
        startNano = System.nanoTime();
        accountClient.GetUserInfo();
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);
    }

    public static void testTrade() {
        String contractCode = "BTCUSDT";
        Long startNano = null;
        Long endNano = null;
        NetworkLatency networkLatency = null;
        TradeClient tradeClient = TradeClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());

        // /api/v1/set_leverage
        startNano = System.nanoTime();
        tradeClient.SetLeverage(contractCode, Direct.Long, new BigDecimal(20));
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/order
        startNano = System.nanoTime();
        Long orderId = tradeClient.CreateOrder(contractCode, OrderTradeType.BuyLong, 10, new BigDecimal(45000));
        endNano = System.nanoTime();
        // System.out.println("orderId:" + orderId);
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/cancel_order
        startNano = System.nanoTime();
        tradeClient.CancelOrder(contractCode, orderId);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/condition_order
        startNano = System.nanoTime();
        tradeClient.CreateConditionOrder(contractCode, OrderTradeType.BuyLong, OrderType.Limit, new BigDecimal(60000),
                10, new BigDecimal(48000));
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/condition_order_info
        startNano = System.nanoTime();
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
        endNano = System.nanoTime();
        // System.out.println("taskId:" + taskId);
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/cancel_condition_order
        startNano = System.nanoTime();
        tradeClient.CancelConditionOrder(contractCode, taskId);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/order_info
        startNano = System.nanoTime();
        tradeClient.GetOpenOrders(contractCode);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/position
        startNano = System.nanoTime();
        tradeClient.GetPositions();
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/order_history
        startNano = System.nanoTime();
        tradeClient.QueryHistoryOrders(new QueryHistoryOrdersRequest() {
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

        }, 1, 10);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/order_history
        startNano = System.nanoTime();
        tradeClient.QueryLiquidationHistory(new QueryLiquidationHistoryRequest() {
            {
                Side = 0;
                ContractCodeList = new ArrayList<String>() {
                    {
                        add(contractCode);
                    }
                };
            }
        }, 1, 10);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/get_orderParas
        startNano = System.nanoTime();
        tradeClient.QueryOrderParas(contractCode);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);
    }

    public static void testWallet() {
        Long startNano = null;
        Long endNano = null;
        NetworkLatency networkLatency = null;
        WalletClient walletClient = WalletClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());

        // /api/v1/account_records
        startNano = System.nanoTime();
        walletClient.GetDepositWithdraw(1, 10);
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);

        // /api/v1/wallet
        startNano = System.nanoTime();
        walletClient.GetUserWallet();
        endNano = System.nanoTime();
        networkLatency = ConnectionFactory.getLatencyDebugQueue().poll();
        print(networkLatency, startNano, endNano);
    }

    public static void print(NetworkLatency networkLatency, Long startNanoTime, Long endNanoTime) {

        long nanoToMicrosecond = 1000;

        Long prepareCost = (networkLatency.getStartNanoTime() - startNanoTime) / nanoToMicrosecond;
        Long deserializationCost = (endNanoTime - networkLatency.getEndNanoTime()) / nanoToMicrosecond;
        Long networkCost = (networkLatency.getEndNanoTime() - networkLatency.getStartNanoTime()) / nanoToMicrosecond;
        Long totalCost = (endNanoTime - startNanoTime) / nanoToMicrosecond;
        Long innerCost = (totalCost - networkCost);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("path:").append(networkLatency.getPath()).append(" prepare:").append(prepareCost)
                .append(" deserializtion:").append(deserializationCost).append(" network:").append(networkCost)
                .append(" inner:").append(innerCost).append(" total:").append(totalCost);

        // stringBuilder.append("|").append(networkLatency.getPath())
        // .append(" |").append(prepareCost)
        // .append(" |").append(deserializationCost)
        // .append(" |").append(networkCost)
        // .append(" |").append(innerCost)
        // .append(" |").append(totalCost);

        System.out.println(stringBuilder.toString());

    }
}
