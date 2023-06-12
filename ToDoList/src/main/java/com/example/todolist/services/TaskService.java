package com.example.todolist.services;

import com.example.todolist.entities.Task;
import com.example.todolist.exceptions.ResourceNotFoundException;
import com.example.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // create a function that receive an int id and return a Task
    @Transactional(readOnly = true)
    public Task getTaskById(Long idTask) {
        return taskRepository.findById(idTask).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + idTask));
    }

    // crea una funcion que reciba una task y la actualice
    @Transactional
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
