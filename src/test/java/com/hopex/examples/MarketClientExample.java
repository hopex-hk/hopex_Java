package com.hopex.examples;

import java.util.Date;

import com.hopex.client.MarketClient;
import com.hopex.constant.HopexOptions;
import com.hopex.model.Enum.CandlestickInterval;

public class MarketClientExample {
    public static void main(String[] args) {
        String contractCode = "BTCUSDT";
        long endTime = (new Date().getTime()) / 1000;
        long before_30min = endTime - 60 * 30;
        long before_24h = endTime - 60 * 60 * 24;
        long before_1week = endTime - 60 * 60 * 24 * 7;
        long before_30day = endTime - 60 * 60 * 24 * 30;
        long before_60day = endTime - 60 * 60 * 24 * 60;
        long before_1year = endTime - 60 * 60 * 24 * 365;

        MarketClient marketClient = MarketClient.create(new HopexOptions());
        // System.out.println(marketClient.GetKline(contractCode, endTime, before_30min, CandlestickInterval.MIN1));
        System.out.println(marketClient.GetKline(contractCode, endTime, before_24h, CandlestickInterval.MIN5));
        // System.out.println(marketClient.GetKline(contractCode, endTime, before_24h, CandlestickInterval.HOUR1));
        // System.out.println(marketClient.GetKline(contractCode, endTime, before_1week, CandlestickInterval.DAY1));
        // System.out.println(marketClient.GetKline(contractCode, endTime, before_30day, CandlestickInterval.WEEK1));
        // System.out.println(marketClient.GetKline(contractCode, endTime, before_1year, CandlestickInterval.MON1));

        System.out.println(marketClient.GetMarketTicker(contractCode));

        System.out.println(marketClient.GetMarkets());

        System.out.println(marketClient.GetTrades(contractCode, 10));

        System.out.println(marketClient.PostQueryMarketDepth(contractCode));
    }
}
