package com.example.demo.repositories;

import com.example.demo.entities.Budget;
import com.example.demo.entities.Cards;
import org.springframework.data.repository.CrudRepository;

public interface CardsRepository extends CrudRepository<Cards, Long> {
    public Long countById(Long card_ID);
}
