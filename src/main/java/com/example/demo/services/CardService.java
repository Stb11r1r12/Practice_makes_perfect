package com.example.demo.services;

import com.example.demo.entities.Cards;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private CardsRepository repo;

    @Autowired
    public CardService(CardsRepository repo){
        this.repo = repo;
    }
    public List<Cards> listAll(){
        return (List<Cards>) repo.findAll();
    }
    public void save(Cards cards) {
        repo.save(cards);
    }

    public Cards get(Long id) throws UserNotFoundException {
        Optional<Cards> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any cards with ID " + id);
    }

    public void delete(Long id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any cards with ID " + id);
        }
        repo.deleteById(id);
    }
}
