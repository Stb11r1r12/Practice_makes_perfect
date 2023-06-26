package com.example.demo.controllers;

import com.example.demo.dto.NotificationDto;
import com.example.demo.entities.Notifications;
import com.example.demo.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<NotificationDto> showCategoriesList() {
        List<Notifications> notifications = service.listAll();
        List<NotificationDto> notificationsDto = new ArrayList<>();
        for(Notifications notification : notifications){
            notificationsDto.add(new NotificationDto(notification));
        }
        return notificationsDto;
    }
}
