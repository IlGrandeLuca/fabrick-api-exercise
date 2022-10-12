package com.example.demo.accountbalance.controller;

import com.example.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
	public ResponseEntity getAccountBalanceFromApiString(@PathVariable("accountId") String accountId) {
		ResponseEntity<String> response = CommonUtils.invokeApi(accountId, "balance", HttpMethod.GET, restTemplate);
		if (response.getStatusCode() != HttpStatus.OK)
			return CommonUtils.checkError(response);
		else
			return response;
	}

}
