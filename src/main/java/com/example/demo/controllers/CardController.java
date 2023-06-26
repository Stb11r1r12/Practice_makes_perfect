package com.example.demo.controllers;

import com.example.demo.dto.BudgetDto;
import com.example.demo.dto.CardsDto;
import com.example.demo.entities.Budget;
import com.example.demo.entities.Cards;
import com.example.demo.services.BudgetService;
import com.example.demo.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/cards")
public class CardController {
    private CardService service;
    @Autowired
    public CardController(CardService service){
        this.service = service;
    }

    @GetMapping
    public List<CardsDto> showBudgetList() {
        List<Cards> cards = service.listAll();
        List<CardsDto> cardsDto = new ArrayList<>();
        for(Cards card : cards){
            cardsDto.add(new CardsDto(card));
        }
        return cardsDto;
    }
}
