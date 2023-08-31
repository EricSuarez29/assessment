package com.metaphorce.assessment.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(columnDefinition = "TINYTEXT", nullable = true)
    public String description;
    @Column
    public TaskStatus status;
    @Column(name = "created_at")
    public LocalDate createdAt;

    @PostPersist
    public void init() {
        this.createdAt = LocalDate.now();
        this.status = TaskStatus.PENDING;
    }
}

enum TaskStatus {
    PENDING,
    PROGRESS,
    DONE
}