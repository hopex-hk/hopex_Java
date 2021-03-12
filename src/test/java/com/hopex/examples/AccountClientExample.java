package com.hopex.examples;

import com.hopex.client.AccountClient;
import com.hopex.constant.Constants;
import com.hopex.constant.HopexOptions;

public class AccountClientExample {
    public static void main(String[] args) {
        AccountClient accountClient = AccountClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());
        System.out.println("get userInfo: " + accountClient.GetUserInfo());
    }

}
