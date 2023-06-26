package com.example.demo.repositories;

import com.example.demo.entities.Goals;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface GoalsRepository extends CrudRepository<Goals, Long> {
    public Long countById(Long goal_ID);
}
