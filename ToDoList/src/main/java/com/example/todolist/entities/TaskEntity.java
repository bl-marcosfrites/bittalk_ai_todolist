package com.example.todolist.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks", schema = "todolist")
public class TaskEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @NotEmpty
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @NotEmpty
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProgressEntity progress;

    @NotEmpty
    @ManyToOne
    @JoinColumn(nullable = false)
    private StatusEntity enabled;
}
