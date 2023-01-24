package com.technicaltest.taskcontrol.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public void addNewTask(Task task)
    {
        taskRepository.save(task);
    }

    public Task findTaskById(Long id)
    {
        return taskRepository.findTaskById(id).get();
    }

    public void updateTask(Long id, String description)
    {
        Task taskToUpdate = taskRepository.findTaskById(id).get();
        taskToUpdate.setDescription(description);
        taskRepository.save(taskToUpdate);
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
}
