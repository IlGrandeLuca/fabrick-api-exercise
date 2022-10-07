package com.example.demo.moneytransfer.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.moneytransfer.model.MoneyTransfer;
import com.google.gson.Gson;

@RestController
@RequestMapping("/money-transfer")
public class MoneyTransferController {

	private static final Gson GSON = new Gson();

	private String apiKey = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/{accountId}")
	public ResponseEntity<String> createMoneyTransfer(@RequestBody MoneyTransfer moneyTransfer,
			@PathVariable("accountId") String accountId) {
		HttpHeaders headers = new HttpHeaders(); // set `content-type` header
		headers.add("Auth-Schema", "S2S");
		headers.add("apikey", apiKey);
		HttpEntity<MoneyTransfer> request = new HttpEntity<MoneyTransfer>(moneyTransfer, headers);
		System.out.printf(ResponseEntity.ok(GSON.toJson(request.getBody())) + "\n");
		ResponseEntity<String> response = restTemplate.exchange(url + accountId + "/payments/money-transfers",
				HttpMethod.POST, request, String.class);
		return ResponseEntity.ok(GSON.toJson(response.getBody()));
	}

}
