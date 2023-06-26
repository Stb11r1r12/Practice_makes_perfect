package com.example.demo.repositories;

import com.example.demo.entities.Categories;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    public Long countById(Long category_ID);
}
