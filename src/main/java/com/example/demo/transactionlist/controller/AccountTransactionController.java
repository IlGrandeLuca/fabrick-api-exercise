package com.example.demo.transactionlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.transactionlist.model.AccountTransaction;
import com.example.demo.transactionlist.service.AccountTransactionService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/transaction")
public class AccountTransactionController {

	private static final Gson GSON = new Gson();

	private String apiKey = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	private String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountTransactionService accountTransactionService;

	@GetMapping("/account-transaction/get-all")
	public List<AccountTransaction> getAllAccountTransaction() {
		return accountTransactionService.getAllAccountTransaction();
	}

	@PostMapping("/account-transaction/save")
	public AccountTransaction save(@RequestBody AccountTransaction accountTransaction) {
		return accountTransactionService.save(accountTransaction);
	}

	@RequestMapping(value = "/{accountId}/{date}", method = RequestMethod.GET)
	public ResponseEntity<String> getAccountTransactionFromApiString(@PathVariable("accountId") String accountId,
			@PathVariable("date") String date) {
		try {
			HttpHeaders headers = new HttpHeaders(); // set `content-type` header
														// headers.setContentType(MediaType.APPLICATION_JSON); // set
														// `accept` header
														// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("Auth-Schema", "S2S");
			headers.add("apikey", apiKey);
			HttpEntity request = new HttpEntity(headers);
			ResponseEntity<String> response = restTemplate.exchange(url + accountId + "/transactions [?<" + date + ">]",
					HttpMethod.GET, request, String.class);

			return ResponseEntity.ok(GSON.toJson(response.getBody()));
		} catch (Exception e) {
			return ResponseEntity.ok(GSON.toJson("Transaction list not found..."));
		}
	}

}
