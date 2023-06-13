package com.example.todolist.services;

import com.example.todolist.entities.Task;
import com.example.todolist.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @Test
    @DisplayName("Should return all tasks when getAllTasks is called")
    void getAllTasksReturnsAllTasks() {
        Task task1 = new Task();
        task1.setId(1);
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setId(2);
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setCompleted(true);

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        assertEquals("Description 1", result.get(0).getDescription());
        assertFalse(result.get(0).getCompleted());
        assertEquals("Task 2", result.get(1).getTitle());
        assertEquals("Description 2", result.get(1).getDescription());
        assertTrue(result.get(1).getCompleted());

        verify(taskRepository, times(1)).findAll();
    }

}