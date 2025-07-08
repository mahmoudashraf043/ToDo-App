package com.mahmoud.To_Do.Controller;

import com.mahmoud.To_Do.Entities.Notification;
import com.mahmoud.To_Do.Service.NotificationService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/")
    public ResponseEntity<List<Notification>> getNotifications() {
        return  new ResponseEntity<>(notificationService.getAllNotifications(), HttpStatus.OK);

    }
}
