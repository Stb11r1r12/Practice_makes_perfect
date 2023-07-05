package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    //@Autowired
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo){
        this.repo = repo;
    }
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public void save(User user) {
        repo.save(user);
    }

    public User get(Long id) {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException("Could not find any users with ID " + id);
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
