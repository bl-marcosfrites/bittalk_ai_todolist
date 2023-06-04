package com.example.todolist.repositories;

import com.example.todolist.entities.ProgressEntity;
import com.example.todolist.entities.StatusEntity;
import com.example.todolist.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    List<TaskEntity> findAllByEnabled(StatusEntity status);
    List<TaskEntity> findAllByProgress(ProgressEntity progress);
}
