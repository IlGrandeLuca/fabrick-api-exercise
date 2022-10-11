package com.example.demo.accountbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/balance")
@Component
public class AccountBalanceController {

	private static final String APIKEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private static final String URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public String getAccountBalanceFromApiString(@PathVariable("accountId") String accountId) {
		HttpHeaders headers = new HttpHeaders(); // set `content-type` header
		headers.add("Auth-Schema", "S2S");
		headers.add("apikey", APIKEY);
		HttpEntity request = new HttpEntity(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(URL + accountId + "/balance", HttpMethod.GET, request,
					String.class);
			return response.getBody();
		} catch (Exception e) {
			return "Account not found...";
		}

	}

}
