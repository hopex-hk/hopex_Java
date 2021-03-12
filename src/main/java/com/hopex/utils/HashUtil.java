package com.hopex.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.hopex.exception.HopexException;

public class HashUtil {
    private static final String signatureMethodValue = "HmacSHA256";

    public static String HmacSha256(String content, String secretKey) {
     

        Mac hmacSha256;
        try {
            hmacSha256 = Mac.getInstance(signatureMethodValue);
            if(secretKey.isBlank()){
                hmacSha256.init(new EmptyKey());
            }else{
                SecretKeySpec secKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), signatureMethodValue);
                hmacSha256.init(secKey);
            }
        } catch (NoSuchAlgorithmException e) {

            throw new HopexException(HopexException.RUNTIME_ERROR, "[Signature] No such algorithm: " + e.getMessage());
        } catch (InvalidKeyException e) {
            throw new HopexException(HopexException.RUNTIME_ERROR, "[Signature] Invalid key: " + e.getMessage());
        }

        return Base64.getEncoder().encodeToString(hmacSha256.doFinal(content.getBytes(StandardCharsets.UTF_8)));
    }

}
