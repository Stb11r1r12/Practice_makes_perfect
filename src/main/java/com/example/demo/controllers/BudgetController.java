package com.example.demo.controllers;

import com.example.demo.dto.BudgetDto;
import com.example.demo.entities.Budget;
import com.example.demo.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {
    private BudgetService service;
    @Autowired
    public BudgetController(BudgetService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BudgetDto>> showBudgetsList(){
        List<Budget> listBudgets = service.listAll();
        List<BudgetDto> listDTO = new ArrayList<BudgetDto>();
        for(Budget budget : listBudgets){
            listDTO.add(new BudgetDto(budget));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BudgetDto> getBudgetById(@PathVariable("id") Long id) {
        Budget budget = service.get(id);
        return new ResponseEntity<>(new BudgetDto(budget), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BudgetDto> createBudget(@RequestBody Budget budget) {
        service.save(budget);
        return new ResponseEntity<>(new BudgetDto(budget), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateBudget(@RequestBody Budget budget) {
        service.save(budget);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBudget(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllBudgets() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
