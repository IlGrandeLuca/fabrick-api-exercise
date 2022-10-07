package com.example.demo.transactionlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.transactionlist.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Long>{

}
