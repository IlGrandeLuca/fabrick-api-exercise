package com.example.demo.accountbalance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.accountbalance.model.AccountBalance;
import com.example.demo.accountbalance.service.AccountBalanceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
@RequestMapping("/balance")
public class AccountBalanceController {

	private static final Gson GSON = new Gson();

	private String apiKey = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountBalanceService accountBalanceService;

	@GetMapping("/account-balance/get-all")
	public List<AccountBalance> getAllAccountBalance() {
		return accountBalanceService.getAllAccountBalance();
	}

	@PostMapping("/account-balance/save")
	public AccountBalance save(@RequestBody AccountBalance accountBalance) {
		return accountBalanceService.save(accountBalance);
	}

//	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
//	public AccountBalance getAccountBalanceFromApi(@PathVariable("accountId") String accountId) {
//		HttpHeaders headers = new HttpHeaders(); // set `content-type` header
//													// headers.setContentType(MediaType.APPLICATION_JSON); // set
//													// `accept` header
//													// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		headers.add("Auth-Schema", "S2S");
//		headers.add("apikey", apiKey);
//		HttpEntity request = new HttpEntity(headers);
//		ResponseEntity<AccountBalance> response = restTemplate.exchange(url + accountId + "/balance", HttpMethod.GET, request, AccountBalance.class);
//		return response.getBody();
//	}

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<String> getAccountBalanceFromApiString(@PathVariable("accountId") String accountId) {
		HttpHeaders headers = new HttpHeaders(); // set `content-type` header
													// headers.setContentType(MediaType.APPLICATION_JSON); // set
													// `accept` header
													// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Auth-Schema", "S2S");
		headers.add("apikey", apiKey);
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(url + accountId + "/balance", HttpMethod.GET, request,
				String.class);

		return ResponseEntity.ok(GSON.toJson(response.getBody()));
	}

}
