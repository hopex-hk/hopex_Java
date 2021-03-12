package com.hopex.examples;

import com.hopex.client.HomeClient;
import com.hopex.constant.HopexOptions;

public class HomeClientExample {
    public static void main(String[] args) {
        HomeClient homeClient = HomeClient.create(new HopexOptions());
        
        System.out.println("get index statistics: " + homeClient.GetIndexStatistics());

        System.out.println("get index notify: " + homeClient.GetIndexNotify(1, 10));
    }
}
