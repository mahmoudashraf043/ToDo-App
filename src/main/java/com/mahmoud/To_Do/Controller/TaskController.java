package com.mahmoud.To_Do.Controller;

import com.mahmoud.To_Do.Entities.Task;
import com.mahmoud.To_Do.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/uncompleted/")
    public ResponseEntity<Page<Task>> getAllUnCompletedTasks(@RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(taskService.getAllUnCompletedTasks(page) , HttpStatus.OK);
    }
    @GetMapping("/completed/")
    public ResponseEntity<Page<Task>> getAllCompletedTasks( @RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(taskService.getAllCompletedTasks(page) , HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable("taskId") int taskId) throws Exception {
        return new ResponseEntity<>(taskService.getTaskById(taskId) , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) throws Exception {
        return new ResponseEntity<>(taskService.createTask(task) , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id,@RequestBody Task task) throws Exception {
        return new ResponseEntity<>(taskService.updateTask(id ,task) , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(taskService.deleteTask(id) , HttpStatus.OK);
    }


}
