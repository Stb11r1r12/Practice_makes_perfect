package com.example.demo.controllers;

import com.example.demo.dto.NotificationDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Notifications;
import com.example.demo.entities.User;
import com.example.demo.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {
    private NotificationService service;
    @Autowired
    public NotificationsController(NotificationService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> showNotificationsList(){
        List<Notifications> listNotifications = service.listAll();
        List<NotificationDto> listDTO = new ArrayList<NotificationDto>();
        for(Notifications notification : listNotifications){
            listDTO.add(new NotificationDto(notification));
        }
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }
    //   @GetMapping("/find/{id}")
//   public UserDto getBuildingById(@PathVariable("id") Long id) {
//      return new UserDto(service.get(id));
//   }
    @GetMapping("/find/{id}")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable("id") Long id) {
        Notifications user = service.get(id);
        return new ResponseEntity<>(new NotificationDto(user), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<NotificationDto> createNotification(@RequestBody Notifications notification) {
        service.save(notification);
        return new ResponseEntity<>(new NotificationDto(notification), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateNotification(@RequestBody Notifications notification) {
        service.save(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllNotifications() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
