package com.example.demo.ut;

import com.example.demo.accountbalance.controller.AccountBalanceController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountBalanceControllerTest {

    private static final String RESPONSE = "{\r\n  \"status\": \"OK\",\r\n  \"error\": [],\r\n  \"payload\": " +
            "{\"date\":\"2022-10-11\",\"balance\":7.17,\"availableBalance\":7.17,\"currency\":\"EUR\"}\r\n}";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private AccountBalanceController accountBalanceController;

    // account balance

  /*  @Test
    public void checkAccountBalanceController() {
        String balance = accountBalanceController.getAccountBalanceFromApiString("14537780");
        Assertions.assertEquals(balance, RESPONSE);
    }*/

}
