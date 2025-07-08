package com.mahmoud.To_Do.Repository;

import com.mahmoud.To_Do.Entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    @Query("select t from Task t where t.user.id = :id and t.completed = false ")
    Page<Task> getAllUnCompletedTasksOfUser(@Param("id") int id , Pageable pageable);

    Optional<Task> findByIdAndCompletedIsFalse(int taskId);

    @Query("select t from Task t where t.user.id = :id and t.completed = true ")
    Page<Task> getAllCompletedTasksOfUser(@Param("id") int id , Pageable pageable);

    @Query("select t from Task t where t.dueDate = :tomorrow")
    List<Task> findTasksEndTomorrow(@Param("tomorrow") LocalDate tomorrow);
}
