package com.example.demo.services;

import com.example.demo.entities.Transactions;
import com.example.demo.entities.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionsService {
    private TransactionRepository repo;

    @Autowired
    public TransactionsService(TransactionRepository repo){
        this.repo = repo;
    }
    public List<Transactions> listAll(){
        return (List<Transactions>) repo.findAll();
    }
    public void save(Transactions transaction) {
        repo.save(transaction);
    }

    public Transactions get(Long id) {
        Optional<Transactions> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any Transactions with ID " + id);
    }
    public void delete(Long id){
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new NoSuchElementException("No such element");
        }
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }
}
