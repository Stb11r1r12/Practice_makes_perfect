package com.example.demo.controllers;

import com.example.demo.dto.CategoriesDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Categories;
import com.example.demo.entities.User;
import com.example.demo.services.CategoryService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<CategoriesDto>> showCategoryList(){
        List<Categories> listCategories = service.listAll();
        List<CategoriesDto> listDTO = new ArrayList<CategoriesDto>();
        for(Categories category : listCategories){
            listDTO.add(new CategoriesDto(category));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    //   @GetMapping("/find/{id}")
//   public UserDto getBuildingById(@PathVariable("id") Long id) {
//      return new UserDto(service.get(id));
//   }
    @GetMapping("/find/{id}")
    public ResponseEntity<CategoriesDto> getCategoryById(@PathVariable("id") Long id) {
        Categories category = service.get(id);
        return new ResponseEntity<>(new CategoriesDto(category), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CategoriesDto> createCategory(@RequestBody Categories category) {
        service.save(category);
        return new ResponseEntity<>(new CategoriesDto(category), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateCategory(@RequestBody Categories category) {
        service.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllCategories() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
