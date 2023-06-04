package com.example.todolist.controllers;

import com.example.todolist.entities.TaskEntity;
import com.example.todolist.services.ProgressService;
import com.example.todolist.services.StatusService;
import com.example.todolist.services.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ProgressService progressService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> getAllTasks(HttpServletRequest request) throws Exception {
        return taskService.getAllTasksOrderByTitle();
    }

    @PostMapping("/create")
    public void createTask(@ModelAttribute TaskEntity task) throws Exception {
        String title = task.getTitle();
        String description = task.getDescription();
        taskService.createTask(title, description);
    }
}
