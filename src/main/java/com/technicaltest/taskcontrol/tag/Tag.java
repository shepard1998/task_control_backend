package com.technicaltest.taskcontrol.tag;

import com.technicaltest.taskcontrol.task.Task;
import jakarta.persistence.*;

@Entity
@Table
public class Tag {
    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    private Long id;
    private String text;

    @ManyToOne
    private Task task;

    public Tag(Long id,
               String text)
    {
        this.id = id;
        this.text = text;
    }

    public Tag() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
