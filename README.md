[![Build Status](https://travis-ci.com/hopex-hk/hopex_Java.svg?branch=main)](https://travis-ci.com/hopex-hk/hopex_Java)

# Hopex Java SDK

This is Hopex Java SDK , you can import to your project and use this SDK to query all market data, trading and manage your account. The SDK supports RESTful API invoking.

## Table of Contents

- [Quick start](#Quick-start)
- [Usage](#Usage)
  - [Folder structure](#Folder-structure)
  - [Run examples](#Run-examples)
  - [Client](#client)
- [Request example](#Request-example)
  - [Home data](#Home-data)
  - [Market data](#Market-data)
  - [Account](#account)
  - [Wallet](#wallet)
  - [Trading](#trading)

## Quick start

*The SDK is compiled by Java8*, you can import the source code in java IDE (idea or eclipse)

The example code are in folder */src/test/java/com/hopex/examples* that you can run directly

If you want to create your own application, you can follow below steps:

* Create the client instance.
* Call the interfaces provided by client.

```java
// Create HomeClient instance and get the index statistics
HomeClient homeClient = HomeClient.create(new HopexOptions());

GetIndexStatisticsResponse res = homeClient.GetIndexStatistics();
System.out.println("get index statistics:" + res);

// Create MarketClient instance and get btcusdt ticker
MarketClient marketClient = MarketClient.create(new HopexOptions());

GetMarketTickerResponse res = marketClient.GetMarketTicker("BTCUSDT");

System.out.println("get btcusdt market ticker:"+ res);
```

## Usage

### Folder Structure

This is the folder and package structure of SDK source code and the description

- **src/main/java/com/hopex**: The core of the SDK
  - **client**: The client that are responsible to access data, this is the external interface layer
  - **constant**: The enum and constant definition
  - **exception**: The exception definition
  - **model**: The data model for response
  - **service**: The internal implementation for each **client**
  - **utils**: The utilities that include signature,inputChecker etc
- **src/test/java/com/hopex**: The test of the SDK
  - **examples**: The examples how to use **client** instance to access API and read response
  - **test**: The additional test such as performance test

### Run Examples


This SDK provides examples that under **src/test/java/com/hopex/example** folder, if you want to run the examples to access private data, you need below additional steps:

1. Create an **API Key** first from Hopex official website
2. Assign your API access key and secret key to "**Constant.java**" as below:

```java
public static final String API_KEY = "a54bf64e-e0b5-4f91-8516-cc6dfc473946"
public static final String SECRET_KEY = "6yJoD76GzpcJUME5SDnCqxUG3oxyJHht"
```

If you don't need to access private data, you can ignore the API key.

Regarding the difference between public data and private data you can find details in [Client](https://github.com/hopex-hk/hopex_Java#Client) section below.

### Client

In this SDK, the client is the class to access the Hopex API. In order to isolate the private data with public data, and isolated different kind of data, the client category is designated to match the API category.

All the client is listed in below table. Each client is very small and simple, it is only responsible to operate its related data, you can pick up multiple clients to create your own application based on your business.

| Data Category | Client        | Privacy | API Protocol       |
| ------------- | ------------- | ------- | ------------------ |
| Market        | MarketClient  | Public  | Rest               |
| Home          | HomeClient    | Public  | Rest               |
| Account       | AccountClient | Private | Rest               |
| Wallet        | WalletClient  | Private | Rest               |
| Trade         | TradeClient   | Private | Rest               |

#### Public and Private

There are two types of privacy that is correspondent with privacy of API:

**Public client**: It invokes public API to get public data (Home data and Market data), therefore you can create a new instance without applying an API Key.

```java
// Create a HomeClient instance
HomeClient homeClient = HomeClient.create(new HopexOptions());

// Create a MarketClient instance
MarketClient marketClient = MarketClient.create(new HopexOptions());
```

**Private client**: It invokes private API to access private data, you need to follow the API document to apply an API Key first, and pass the API Key to the init function

```java
// Create an AccountClient instance with APIKey
AccountClient accountService = AccountClient.create(HopexOptions.builder()
        .apiKey(Constants.API_KEY)
        .secretKey(Constants.SECRET_KEY)
        .build());

// Create a TradeClient instance with API Key
TradeClient tradeService = TradeClient.create(HopexOptions.builder()
        .apiKey(Constants.API_KEY)
        .secretKey(Constants.SECRET_KEY)
        .build());
```

The API key is used for authentication. If the authentication cannot pass, the invoking of private interface will fail.

#### Rest

It invokes Rest API and get once-off response, it has two basic types of method: GET and POST

## Request example

### Home data

#### Get Index Notify

```java
HomeClient homeClient = HomeClient.create(new HopexOptions());
ListResultViewModel<GetIndexNotifyResponse> res = homeClient.GetIndexNotify(1, 10);
```
#### Get Index Notify
```java
HomeClient homeClient = HomeClient.create(new HopexOptions());
GetIndexStatisticsResponse res = homeClient.GetIndexStatistics();
```
### Market data

#### Kline

```java
MarketClient marketClient = MarketClient.create(new HopexOptions());
long endTime = (new Date().getTime()) / 1000;
long before_24h = endTime - 60 * 60 * 24;
GetKlineResponse res = marketClient.GetKline("BTCUSDT", endTime, before_24h, CandlestickInterval.MIN5);
```

#### Depth

```java
MarketClient marketClient = MarketClient.create(new HopexOptions());
PostQueryMarketDepthResponse res = marketClient.PostQueryMarketDepth("BTCUSDT");
```

#### Latest trade

```java
MarketClient marketClient = MarketClient.create(new HopexOptions());
List<GetTradesResponse> res = marketClient.GetTrades(contractCode, 10);
```

### Account

*Authentication is required.*

#### Get user account info

```java
AccountClient accountClient = AccountClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());

GetUserInfoResponse res = accountClient.GetUserInfo();
```

### Wallet

*Authentication is required.*

#### Deposit or Withdraw

```java
WalletClient walletClient = WalletClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());

ListResultViewModel<GetDepositWithdrawResponse> res = walletClient.GetDepositWithdraw(1, 10);
```

#### User Wallet

```java
WalletClient walletClient = WalletClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
GetUserWalletResponse res = walletClient.GetUserWallet();
```

### Trading

*Authentication is required.*

#### Create order

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());

Long limitLongOrderId = tradeClient.CreateOrder("BTCUSDT", OrderTradeType.BuyLong, 10,  new BigDecimal(45000));
```

#### Cancel order

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
Boolean cancelRes = tradeClient.CancelOrder("BTCUSDT", limitLongOrderId);
```

#### Create condition order

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
Boolean createLimitConditionOrderRes = tradeClient.CreateConditionOrder(contractCode, OrderTradeType.BuyLong, OrderType.Limit, new BigDecimal(60000), 10, new BigDecimal(48000));
```

#### Cancel condition order

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
long taskId = 1000000
Boolean cancelRes = tradeClient.CancelConditionOrder("BTCUSDT", taskId);
```

#### Get open order

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
List<GetOpenOrdersResponse> res = tradeClient.GetOpenOrders("BTCUSDT");
```

#### Get Historical orders

```java
TradeClient tradeClient = TradeClient.create(HopexOptions.builder()
    .apiKey(Constants.API_KEY)
    .secretKey(Constants.SECRET_KEY)
    .build());
ListResultViewModel<QueryHistoryOrdersResponse> res = tradeClient.QueryHistoryOrders(
    new QueryHistoryOrdersRequest() {
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

```