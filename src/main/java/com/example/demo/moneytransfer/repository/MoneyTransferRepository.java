package com.example.demo.moneytransfer.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.moneytransfer.model.MoneyTransfer;

public interface MoneyTransferRepository extends CrudRepository<MoneyTransfer, Long> {

}
