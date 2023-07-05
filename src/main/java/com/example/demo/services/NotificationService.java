package com.example.demo.services;

import com.example.demo.entities.Notifications;
import com.example.demo.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NotificationService {
    private NotificationRepository repo;

    @Autowired
    public NotificationService(NotificationRepository repo){
        this.repo = repo;
    }
    public List<Notifications> listAll(){
        return (List<Notifications>) repo.findAll();
    }
    public void save(Notifications budget) {
        repo.save(budget);
    }

    public Notifications get(Long id) {
        Optional<Notifications> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any Notifications with ID " + id);
    }
    public void delete(Long id){
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new NoSuchElementException("No such element");
        }
        repo.deleteById(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }
}
