package com.example.demo.transactionlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/transaction")
public class AccountTransactionController {

	private static final String APIKEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private static final String URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/{accountId}/{date}", method = RequestMethod.GET)
	public ResponseEntity<String> getAccountTransactionFromApiString(@PathVariable("accountId") String accountId,
			@PathVariable("date") String date) {
		try {
			HttpHeaders headers = new HttpHeaders(); // set `content-type` header
			headers.add("Auth-Schema", "S2S");
			headers.add("apikey", APIKEY);
			HttpEntity request = new HttpEntity(headers);
			ResponseEntity<String> response = restTemplate.exchange(URL + accountId + "/transactions [?<" + date + ">]",
					HttpMethod.GET, request, String.class);

			return ResponseEntity.ok(response.getBody());
		} catch (Exception e) {
			return ResponseEntity.ok("Transaction list not found...");
		}
	}

}
