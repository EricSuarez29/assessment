package com.metaphorce.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metaphorce.assessment.models.Task;

public interface ITaskRepository extends JpaRepository<Task, Integer> {

}
