package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
   //@Autowired
   private UserService service;
   @Autowired
   public UserController(UserService service){
      this.service = service;
   }

   @GetMapping
   public List<UserDto> showUserList() {
      List<User> users = service.listAll();
      List<UserDto> usersDto = new ArrayList<UserDto>();
      for(User user : users){
         usersDto.add(new UserDto(user));
      }
       return usersDto;
   }

   @GetMapping("/new")
   public void addUser(User user) {
      //service.;
   }

//   @PostMapping("/users/save")
//   public String saveUser(User user, RedirectAttributes ra) {
//      service.save(user);
//      ra.addFlashAttribute("message", "The user has been saved successfully.");
//      return "redirect:/user";
//   }

   @PostMapping("/save")// ?
   public void saveUser(User user) {
      service.save(user);
      return;
   }

//   @GetMapping("/users/edit/{user_ID}")
//   public String showEditForm(@PathVariable("id") Long user_ID, Model model, RedirectAttributes ra) {
//      try {
//         User user = service.get(user_ID);
//         model.addAttribute("user", user);
//         model.addAttribute("pageTitle", "Edit User (ID: " + user_ID + ")");
//
//         return "user_form";
//      } catch (UserNotFoundException e) {
//         ra.addFlashAttribute("message", e.getMessage());
//         return "redirect:/users";
//      }
//   }

   @GetMapping("/edit/{id}")
   public void showEditForm(@PathVariable("id") Long user_ID) {
      try {
         User user = service.get(user_ID);
         user.setPassword("123321");// ?
      } catch (UserNotFoundException e) {
         e.getMessage();
      }
   }
//   @GetMapping("/edit/{user_ID}")
//   public String showEditForm(@PathVariable("id") Long user_ID, Model model, RedirectAttributes ra) {
//      try {
//         User user = service.get(user_ID);
//         model.addAttribute("user", user);
//         model.addAttribute("pageTitle", "Edit User (ID: " + user_ID + ")");
//         return "user_form";
//      } catch (UserNotFoundException e) {
//         ra.addFlashAttribute("message", e.getMessage());
//         return "redirect:/users";
//      }
//   }
   @GetMapping("/delete/{id}")
   public String deleteUser(@PathVariable("id") Long user_ID, RedirectAttributes ra) {
      try {
         service.delete(user_ID);
         ra.addFlashAttribute("message", "The user ID " + user_ID + " has been deleted.");
      } catch (UserNotFoundException e) {
         ra.addFlashAttribute("message", e.getMessage());
      }
      return "redirect:/users";
   }
}
