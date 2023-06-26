package com.example.demo.controllers;

import com.example.demo.dto.BudgetDto;
import com.example.demo.entities.Budget;
import com.example.demo.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<BudgetDto> showBudgetList() {
        List<Budget> budgets = service.listAll();
        List<BudgetDto> budgetsDto = new ArrayList<>();
        for(Budget budget : budgets){
            budgetsDto.add(new BudgetDto(budget));
        }
        return budgetsDto;
    }
}
