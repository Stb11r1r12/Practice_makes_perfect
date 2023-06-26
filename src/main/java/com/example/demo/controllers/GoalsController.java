package com.example.demo.controllers;

import com.example.demo.dto.GoalsDto;
import com.example.demo.entities.Goals;
import com.example.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalsController {
    private GoalService service;
    @Autowired
    public GoalsController(GoalService service){
        this.service = service;
    }

    @GetMapping
    public List<GoalsDto> showCategoriesList() {
        List<Goals> goals = service.listAll();
        List<GoalsDto> goalsDto = new ArrayList<>();
        for(Goals goal : goals){
            goalsDto.add(new GoalsDto(goal));
        }
        return goalsDto;
    }
}
