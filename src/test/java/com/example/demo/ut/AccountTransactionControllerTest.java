package com.example.demo.ut;

import com.example.demo.transactionlist.controller.AccountTransactionController;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountTransactionControllerTest {

    private static final Gson GSON = new Gson();

    @Autowired
    private AccountTransactionController accountTransactionController;

    // account transaction list

    @Test
    public void accountTransactionCallApi() {
        ResponseEntity<String> result = accountTransactionController
                .getAccountTransactionFromApiString("14537780", "fromAccountingDate=2019-04-01");
        String response = "Transaction list not found...";
        Assertions.assertEquals(result.getBody(), response);
    }

}
