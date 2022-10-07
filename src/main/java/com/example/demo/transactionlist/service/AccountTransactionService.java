package com.example.demo.transactionlist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.example.demo.transactionlist.model.AccountTransaction;
import com.example.demo.transactionlist.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {
	
	@Autowired
	AccountTransactionRepository repository;

	public AccountTransaction save(AccountTransaction accountTransaction) {
		return repository.save(accountTransaction);
	}

	public List<AccountTransaction> getAllAccountTransaction() {
		List<AccountTransaction> accountTransaction = new ArrayList<>();
		Streamable.of(repository.findAll()).forEach(accountTransaction::add);
		return accountTransaction;
	}

	public void delete(long accountId) {
		repository.deleteById(accountId);
	}

}
