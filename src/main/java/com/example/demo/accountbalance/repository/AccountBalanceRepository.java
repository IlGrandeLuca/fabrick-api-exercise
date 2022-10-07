package com.example.demo.accountbalance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.accountbalance.model.AccountBalance;

@Repository
public interface AccountBalanceRepository extends CrudRepository<AccountBalance, Long> {

}
