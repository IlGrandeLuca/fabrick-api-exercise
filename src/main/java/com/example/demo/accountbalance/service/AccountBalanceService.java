package com.example.demo.accountbalance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.example.demo.accountbalance.model.AccountBalance;
import com.example.demo.accountbalance.repository.AccountBalanceRepository;

@Service
public class AccountBalanceService {

	@Autowired
	AccountBalanceRepository repository;

	public AccountBalance save(AccountBalance accountBalance) {
		return repository.save(accountBalance);
	}

	public List<AccountBalance> getAllAccountBalance() {
		List<AccountBalance> accountBalance = new ArrayList<>();
		Streamable.of(repository.findAll()).forEach(accountBalance::add);
		return accountBalance;
	}

	public void delete(long accountId) {
		repository.deleteById(accountId);
	}

}
