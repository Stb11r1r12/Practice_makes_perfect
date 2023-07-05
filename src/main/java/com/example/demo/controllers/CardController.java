package com.example.demo.controllers;

import com.example.demo.dto.CardsDto;
import com.example.demo.entities.Cards;
import com.example.demo.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<CardsDto>> showCardsList(){
        List<Cards> listCards = service.listAll();
        List<CardsDto> listDTO = new ArrayList<CardsDto>();
        for(Cards card : listCards){
            listDTO.add(new CardsDto(card));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CardsDto> getCardById(@PathVariable("id") Long id) {
        Cards card = service.get(id);
        return new ResponseEntity<>(new CardsDto(card), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CardsDto> createCard(@RequestBody Cards card) {
        service.save(card);
        return new ResponseEntity<>(new CardsDto(card), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateCard(@RequestBody Cards card) {
        service.save(card);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCard(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllCards() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
