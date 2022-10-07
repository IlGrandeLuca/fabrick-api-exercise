package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.accountbalance.controller.AccountBalanceController;
import com.example.demo.accountbalance.model.AccountBalance;
import com.example.demo.accountbalance.service.AccountBalanceService;
import com.example.demo.transactionlist.controller.AccountTransactionController;
import com.example.demo.transactionlist.model.AccountTransaction;
import com.example.demo.transactionlist.service.AccountTransactionService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class FabrickApiExerciseApplicationTests {

	@Autowired
	private AccountBalanceService accountBalanceService;
	
	@Autowired
	private AccountBalanceController accountBalanceController;

	@Autowired
	private AccountTransactionService accountTransactionService;
	
	@Autowired
	private AccountTransactionController accountTransactionController;

	// account balance

	@BeforeAll
	public void clearBalances() {
		List<AccountBalance> accountBalances = accountBalanceService.getAllAccountBalance();
		for (AccountBalance accountBalance : accountBalances) {
			accountBalanceService.delete(accountBalance.getAccountId());
		}
	}

	@Test
	void addAccountBalanceTest() {
		String date_string = "05-10-2022";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(date_string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addAccountBalance(123456, "Europe", date, 28.01, 28.02, "EUR");
		
//		AccountBalance balance = accountBalanceController.getAccountBalanceFromApi("14537780");
//		accountBalanceService.save(balance);
		
	}
	
	@Test
	void accountBalanceCallApi() {
		accountBalanceController.getAccountBalanceFromApiString("14537780");
	}

	private void addAccountBalance(long accountId, String xTimeZone, Date date, double balance, double availableBalance,
			String currency) {
		AccountBalance accountBalance = new AccountBalance();
		accountBalance.setAccountId(accountId);
		accountBalance.setxTimeZone(xTimeZone);
		accountBalance.setDate(date);
		accountBalance.setBalance(balance);
		accountBalance.setAvailableBalance(availableBalance);
		accountBalance.setCurrency(currency);
		accountBalanceService.save(accountBalance);
	}

	// account transaction list

	@BeforeAll
	public void clearTransactions() {
		List<AccountBalance> accountTransactions = accountBalanceService.getAllAccountBalance();
		for (AccountBalance accountTransaction : accountTransactions) {
			accountBalanceService.delete(accountTransaction.getAccountId());
		}
	}

	@Test
	void addAccountTransactionTest() {
		String date_string1 = "06-10-2022";
		String date_string2 = "07-10-2022";
		String date_string3 = "10-10-2022";
		String date_string4 = "03-10-2022";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date fromAccountingDate = null;
		Date toAccountingDate = null;
		Date accountingDate = null;
		Date valueDate = null;
		try {
			fromAccountingDate = formatter.parse(date_string1);
			toAccountingDate = formatter.parse(date_string2);
			accountingDate = formatter.parse(date_string3);
			valueDate = formatter.parse(date_string4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addAccountTransaction(123456, fromAccountingDate, toAccountingDate, "Europe", "ABC123", "DEF456", accountingDate, valueDate, 33, 100, "EUR", "Test description...");
	}

	private void addAccountTransaction(long accountId, Date fromAccountingDate, Date toAccountingDate, String xTimeZone,
			String transactionId, String operationId, Date accountingDate, Date valueDate, int type, int amount,
			String currency, String description) {
		AccountTransaction accountTransaction = new AccountTransaction();
		accountTransaction.setAccountId(accountId);
		accountTransaction.setFromAccountingDate(fromAccountingDate);
		accountTransaction.setToAccountingDate(toAccountingDate);
		accountTransaction.setxTimeZone(xTimeZone);
		accountTransaction.setTransactionId(transactionId);
		accountTransaction.setOperationId(operationId);
		accountTransaction.setAccountingDate(accountingDate);
		accountTransaction.setValueDate(valueDate);
		accountTransaction.setType(type);
		accountTransaction.setAmount(amount);
		accountTransaction.setCurrency(currency);
		accountTransaction.setDescription(description);
		accountTransactionService.save(accountTransaction);
	}
	
	@Test
	void accountTransactionCallApi() {
		accountTransactionController.getAccountTransactionFromApiString("14537780", "fromAccountingDate=2019-04-01");
	}

	// money transfer

}
