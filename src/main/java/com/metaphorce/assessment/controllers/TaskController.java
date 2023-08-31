package com.metaphorce.assessment.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.assessment.models.Task;
import com.metaphorce.assessment.repository.ITaskRepository;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final ITaskRepository taskRepository;

    public TaskController(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> createTasks(Task task) {
        Task taskCreated = taskRepository.save(task);
        return ResponseEntity.ok(taskCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, Task task) {
        Task currentTask = taskRepository.findById(id).orElseGet(() -> null);
        if (currentTask == null) {
            return ResponseEntity.notFound().build();
        }
        if (task.description != null)
            currentTask.description = task.description;
        if (task.description != null)
            currentTask.status = task.status;
        taskRepository.save(currentTask);
        return ResponseEntity.ok(currentTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
