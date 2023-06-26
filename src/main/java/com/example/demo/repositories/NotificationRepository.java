package com.example.demo.repositories;

import com.example.demo.entities.Notifications;
import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notifications, Long> {
    public Long countById(Long notification_ID);
}
