package com.example.demo.services;


import com.example.demo.entities.Goals;
import com.example.demo.repositories.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GoalService {
    private GoalsRepository repo;

    @Autowired
    public GoalService(GoalsRepository repo){
        this.repo = repo;
    }
    public List<Goals> listAll(){
        return (List<Goals>) repo.findAll();
    }
    public void save(Goals budget) {
        repo.save(budget);
    }

    public Goals get(Long id) {
        Optional<Goals> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any Goals with ID " + id);
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
