package com.example.demo.controllers;

import com.example.demo.dto.CategoriesDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Categories;
import com.example.demo.entities.User;
import com.example.demo.services.CategoryService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService service;
    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping
    public List<CategoriesDto> showCategoriesList() {
        List<Categories> categories = service.listAll();
        List<CategoriesDto> categoriesDto = new ArrayList<>();
        for(Categories category : categories){
            categoriesDto.add(new CategoriesDto(category));
        }
        return categoriesDto;
    }
}
