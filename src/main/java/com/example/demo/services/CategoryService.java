package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.entities.Notifications;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoriesRepository repo;

    @Autowired
    public CategoryService(CategoriesRepository repo){
        this.repo = repo;
    }
    public List<Categories> listAll(){
        return (List<Categories>) repo.findAll();
    }
    public void save(Categories user) {
        repo.save(user);
    }
    public Categories get(Long id) {
        Optional<Categories> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any Categories with ID " + id);
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
