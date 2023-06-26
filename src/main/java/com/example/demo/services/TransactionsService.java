package com.example.demo.services;

import com.example.demo.entities.Transactions;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Transactions get(Long id) throws UserNotFoundException {
        Optional<Transactions> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any Transactions with ID " + id);
    }

    public void delete(Long id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any Transactions with ID " + id);
        }
        repo.deleteById(id);
    }
}
