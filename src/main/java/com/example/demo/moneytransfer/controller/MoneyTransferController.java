package com.example.demo.moneytransfer.controller;

import com.example.demo.moneytransfer.model.MoneyTransfer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/money-transfer")
public class MoneyTransferController {

	private static final Gson GSON = new Gson();
	private static final String APIKEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private static final String URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/{accountId}")
	public ResponseEntity<String> createMoneyTransfer(@RequestBody MoneyTransfer moneyTransfer,
			@PathVariable("accountId") String accountId) {
		HttpHeaders headers = new HttpHeaders(); // set `content-type` header
		headers.add("Auth-Schema", "S2S");
		headers.add("apikey", APIKEY);
		HttpEntity<MoneyTransfer> request = new HttpEntity<MoneyTransfer>(moneyTransfer, headers);
		System.out.printf(ResponseEntity.ok(GSON.toJson(request.getBody())) + "\n");
		try {
		ResponseEntity<String> response = restTemplate.exchange(URL + accountId + "/payments/money-transfers",
				HttpMethod.POST, request, String.class);
			return ResponseEntity.ok(GSON.toJson(response.getBody()));
		} catch(Exception e) {
			return ResponseEntity.ok(GSON.toJson(e.getMessage()));
		}

	}

}
