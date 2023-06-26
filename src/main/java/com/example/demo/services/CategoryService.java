package com.example.demo.services;

import com.example.demo.entities.Categories;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Categories get(Long id) throws UserNotFoundException {
        Optional<Categories> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any Categories with ID " + id);
    }

    public void delete(Long id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any Categories with ID " + id);
        }
        repo.deleteById(id);
    }
}
