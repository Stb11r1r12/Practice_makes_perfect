package com.example.demo.repositories;

import com.example.demo.entities.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
    public Long countById(Long budget_ID);
}
