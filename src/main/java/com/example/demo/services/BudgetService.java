package com.example.demo.services;

import com.example.demo.entities.Budget;
import com.example.demo.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class BudgetService {
    private BudgetRepository repo;

    @Autowired
    public BudgetService(BudgetRepository repo){
        this.repo = repo;
    }
    public List<Budget> listAll(){
        return (List<Budget>) repo.findAll();
    }
    public void save(Budget budget) {
        repo.save(budget);
    }

    public Budget get(Long id) {
        Optional<Budget> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any Budget with ID " + id);
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
