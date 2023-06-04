package com.example.todolist.services;

import com.example.todolist.entities.ProgressEntity;
import com.example.todolist.entities.StatusEntity;
import com.example.todolist.entities.TaskEntity;
import com.example.todolist.repositories.TaskRepository;
import com.example.todolist.services.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getAllTasksOrderByTitle() throws Exception {
        return null;
    }

    @Override
    @Transactional
    public void createTask(String title, String description) throws Exception {
        try {
            TaskEntity task = new TaskEntity();
            task.setTitle(title);
            task.setDescription(description);
            taskRepository.save(task);
        } catch (Exception exception) {
            throw new Exception(String.format("Error while creating task entity: %s", exception.getMessage()));
        }
    }

    @Override
    @Transactional
    public void updateTask(Integer id, String title, String description, ProgressEntity progress, StatusEntity status) throws Exception {
        try {
            TaskEntity task = taskRepository.findById(id).get();
            task.setTitle(title);
            task.setDescription(description);
            task.setProgress(progress);
            task.setEnabled(status);
            taskRepository.save(task);
        } catch (Exception exception) {
            throw new Exception(String.format("Error while updating task entity: %s", exception.getMessage()));
        }
    }

    @Override
    @Transactional
    public void deleteTask(Integer id) throws Exception {
        try {
            TaskEntity task = taskRepository.findById(id).get();
            taskRepository.delete(task);
        } catch (Exception exception) {
            throw new Exception(String.format("Error while deleting task entity: %s", exception.getMessage()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public TaskEntity findTaskById(Integer id) throws Exception {
        try {
            TaskEntity task = taskRepository.findById(id).get();
            if (task == null) {
                throw new Exception("Task not found");
            }
            return task;
        } catch (Exception exception) {
            throw new Exception(String.format("Error while finding task entity by id: %s", exception.getMessage()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskEntity> getAllTasksByStatus(StatusEntity status) throws Exception {
        try {
            List<TaskEntity> tasks = taskRepository.findAllByEnabled(status);
            if (tasks == null) {
                throw new Exception("Tasks not found");
            }
            return tasks;
        } catch (Exception exception) {
            throw new Exception(String.format("Error while finding task entities by status: %s", exception.getMessage()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskEntity> getAllTasksByProgress(ProgressEntity progress) throws Exception {
        try {
            List<TaskEntity> tasks = taskRepository.findAllByProgress(progress);
            if (tasks == null) {
                throw new Exception("Tasks not found");
            }
            return tasks;
        } catch (Exception exception) {
            throw new Exception(String.format("Error while finding task entities by progress: %s", exception.getMessage()));
        }
    }
}
