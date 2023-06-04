package com.example.todolist.services.interfaces;

import com.example.todolist.entities.ProgressEntity;
import com.example.todolist.entities.StatusEntity;
import com.example.todolist.entities.TaskEntity;

import java.util.List;

public interface ITaskService {
    public List<TaskEntity> getAllTasksOrderByTitle() throws Exception;
    public void createTask(String title, String description) throws Exception;
    public void updateTask(Integer id, String title, String description, ProgressEntity progress, StatusEntity status) throws Exception;
    public void deleteTask(Integer id) throws Exception;
    public TaskEntity findTaskById(Integer id) throws Exception;
    public List<TaskEntity> getAllTasksByStatus(StatusEntity status) throws Exception;
    public List<TaskEntity> getAllTasksByProgress(ProgressEntity progress) throws Exception;
}
