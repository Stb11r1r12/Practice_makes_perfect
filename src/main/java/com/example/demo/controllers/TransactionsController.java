package com.example.demo.controllers;

import com.example.demo.dto.TransactionsDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Transactions;
import com.example.demo.entities.User;
import com.example.demo.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    private TransactionsService service;
    @Autowired
    public TransactionsController(TransactionsService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TransactionsDto>> showTransactionsList(){
        List<Transactions> listTransactions = service.listAll();
        List<TransactionsDto> listDTO = new ArrayList<TransactionsDto>();
        for(Transactions transaction : listTransactions){
            listDTO.add(new TransactionsDto(transaction));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    //   @GetMapping("/find/{id}")
//   public UserDto getBuildingById(@PathVariable("id") Long id) {
//      return new UserDto(service.get(id));
//   }
    @GetMapping("/find/{id}")
    public ResponseEntity<TransactionsDto> getTransactionById(@PathVariable("id") Long id) {
        Transactions transaction = service.get(id);
        return new ResponseEntity<>(new TransactionsDto(transaction), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<TransactionsDto> createTransaction(@RequestBody Transactions transaction) {
        service.save(transaction);
        return new ResponseEntity<>(new TransactionsDto(transaction), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateTransaction(@RequestBody Transactions transaction) {
        service.save(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllTransactions() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
