package com.example.demo.repositories;

import com.example.demo.entities.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transactions, Long> {
    public Long countById(Long transaction_ID);
}
