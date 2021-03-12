package com.hopex.examples;

import com.hopex.client.WalletClient;
import com.hopex.constant.Constants;
import com.hopex.constant.HopexOptions;

public class WalletClientExample {
    public static void main(String[] args) {
        WalletClient walletClient = WalletClient
                .create(HopexOptions.builder().apiKey(Constants.API_KEY).secretKey(Constants.SECRET_KEY).build());

        System.out.println(walletClient.GetDepositWithdraw(1, 10));
        
        System.out.println(walletClient.GetUserWallet());
    }
}
