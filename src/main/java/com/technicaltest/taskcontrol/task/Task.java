package com.technicaltest.taskcontrol.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technicaltest.taskcontrol.tag.Tag;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "task")
    private Set<Tag> tags = new HashSet<>();

    public Task(Long id)
    {
        this.id = id;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
