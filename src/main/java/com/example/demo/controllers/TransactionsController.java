package com.example.demo.controllers;

import com.example.demo.dto.TransactionsDto;
import com.example.demo.entities.Transactions;
import com.example.demo.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<TransactionsDto> showCategoriesList() {
        List<Transactions> transactions = service.listAll();
        List<TransactionsDto> transactionsDto = new ArrayList<>();
        for(Transactions transaction : transactions){
            transactionsDto.add(new TransactionsDto(transaction));
        }
        return transactionsDto;
    }
}
