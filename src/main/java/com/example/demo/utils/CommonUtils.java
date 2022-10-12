package com.example.demo.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.example.demo.utils.CommonConstants.APIKEY;
import static com.example.demo.utils.CommonConstants.URL;

@Component
public class CommonUtils {

    public static HttpEntity<Void> getHeader() {

        HttpHeaders headers = new HttpHeaders(); // set `content-type` header
        headers.add("Auth-Schema", "S2S");
        headers.add("apikey", APIKEY);
        return new HttpEntity<>(headers);

    }

    public static ResponseEntity<String> invokeApi(String accountId, String api, HttpMethod method, RestTemplate restTemplate) {
        return restTemplate.exchange(URL + accountId + "/" + api, method, getHeader(),
                String.class);
    }

    public static ResponseEntity<String> checkError(ResponseEntity<String> response) {
        //String error = "Response code: " + response.getStatusCodeValue() + "message: " + response.getBody();
        return ResponseEntity.status(response.getStatusCodeValue()).body(response.getBody());
    }

}
