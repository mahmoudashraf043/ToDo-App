package com.mahmoud.To_Do.Repository;

import com.mahmoud.To_Do.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer> {
    @Query("select n from Notification n where n.user.id =:id")
    List<Notification> findAllByUserId(@Param("id") int id);
}
