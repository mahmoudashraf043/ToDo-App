package com.mahmoud.To_Do.Service;

import com.mahmoud.To_Do.Entities.Notification;
import com.mahmoud.To_Do.Entities.Task;
import com.mahmoud.To_Do.Entities.User;
import com.mahmoud.To_Do.Repository.NotificationRepo;
import com.mahmoud.To_Do.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    NotificationRepo notificationRepo;

    @Scheduled(cron = "0 0 9 * * *") // every day at 9 AM
    public void sendNotification() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<Task> tasks = taskRepo.findTasksEndTomorrow(tomorrow);
        for (Task task : tasks) {
            Notification notification = new Notification();
            notification.setUser(task.getUser());
            notification.setMessage("Task :" + task.getTitle() + "   will end tomorrow");
            notification.setSeen(false);
            notification.setCreatedAt(LocalDateTime.now());
            notificationRepo.save(notification);
        }
    }

    public List<Notification> getAllNotifications() {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return notificationRepo.findAllByUserId(user.getId());
    }

    public String markNotificationAsSeen(int id) {
        Notification notification = notificationRepo.findById(id).orElseThrow(() -> new RuntimeException("Notification Not Found"));
        notification.setSeen(true);
        notificationRepo.save(notification);
        return "Notification Marked as Seen";
    }
}
