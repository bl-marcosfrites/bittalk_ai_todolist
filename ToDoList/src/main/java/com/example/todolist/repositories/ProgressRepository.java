package com.example.todolist.repositories;

import com.example.todolist.entities.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressEntity, Integer> {

}
