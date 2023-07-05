package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   private UserService service;
   @Autowired
   public UserController(UserService service){
      this.service = service;
   }

   @GetMapping
   public ResponseEntity<List<UserDto>> showUserList(){
      List<User> listUsers = service.listAll();
      List<UserDto> listDTO = new ArrayList<UserDto>();
      for(User user : listUsers){
         listDTO.add(new UserDto(user));
      }
      return new ResponseEntity<>(listDTO, HttpStatus.OK);
   }
   @GetMapping("/find/{id}")
   public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
      User user = service.get(id);
      return new ResponseEntity<>(new UserDto(user), HttpStatus.OK);
   }
   @PostMapping("/create")
   public ResponseEntity<UserDto> createUser(@RequestBody User user) {
      service.save(user);
      return new ResponseEntity<>(new UserDto(user), HttpStatus.CREATED);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
      service.save(user);
      return new ResponseEntity<>(HttpStatus.OK);
   }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
      try {
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
   @DeleteMapping("/deleteAll")
   public ResponseEntity<HttpStatus> deleteAllUsers() {
      try {
         service.deleteAll();
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }

}
