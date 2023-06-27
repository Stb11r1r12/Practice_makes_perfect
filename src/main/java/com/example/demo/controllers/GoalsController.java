package com.example.demo.controllers;

import com.example.demo.dto.GoalsDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Goals;
import com.example.demo.entities.User;
import com.example.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<GoalsDto>> showGoalsList(){
        List<Goals> listBuildings = service.listAll();
        List<GoalsDto> listDTO = new ArrayList<GoalsDto>();
        for(Goals goal : listBuildings){
            listDTO.add(new GoalsDto(goal));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    //   @GetMapping("/find/{id}")
//   public UserDto getBuildingById(@PathVariable("id") Long id) {
//      return new UserDto(service.get(id));
//   }
    @GetMapping("/find/{id}")
    public ResponseEntity<GoalsDto> getGoalsById(@PathVariable("id") Long id) {
        Goals goal = service.get(id);
        return new ResponseEntity<>(new GoalsDto(goal), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<GoalsDto> createGoal(@RequestBody Goals goal) {
        service.save(goal);
        return new ResponseEntity<>(new GoalsDto(goal), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateGoal(@RequestBody Goals goal) {
        service.save(goal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGoal(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllGoals() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
