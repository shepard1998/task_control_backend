package com.technicaltest.taskcontrol.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/task")
public class TaskController
{
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks()
    {
        return taskService.getTasks();
    }

    @PostMapping
    public Task registerNewTask(@RequestBody Task task)
    {
        taskService.addNewTask(task);
        return task;
    }

    @PutMapping("/update/{taskId}")
    public void updateTask(
            @PathVariable Long taskId,
            @RequestBody String description
    )
    {
        taskService.updateTask(taskId, description);
    }

    @PutMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable Long taskId)
    {
        taskService.deleteTask(taskId);
    }
}
