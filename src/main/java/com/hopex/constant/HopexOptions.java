package com.hopex.constant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HopexOptions implements Options {

    @Builder.Default
    private String restHost = "https://api2.hopex.com";

    @Builder.Default
    private String UserAgent = ""; 

    private String apiKey;

    private String secretKey;

    @Override
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public String getSecretKey() {
        return this.secretKey;
    }

    @Override
    public String getRestHost() {
        return this.restHost;
    }

    @Override
    public String getUserAgent() {
        return this.UserAgent;
    }

}
