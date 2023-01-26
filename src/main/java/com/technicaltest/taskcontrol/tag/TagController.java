package com.technicaltest.taskcontrol.tag;

import com.technicaltest.taskcontrol.task.Task;
import com.technicaltest.taskcontrol.task.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tag")
public class TagController
{
    private final TagService tagService;
    private final TaskService taskService;

    public TagController(TagService tagService, TaskService taskService) {
        this.tagService = tagService;
        this.taskService = taskService;
    }

    @GetMapping
    public List<Tag> getTags(){
        return tagService.getTags();
    }

    @PostMapping
    public Tag registerNewTag(@RequestBody Tag tag)
    {
        tagService.addNewTag(tag);
        return tag;
    }

    @PutMapping("/{tagId}/task/{taskId}")
    public Tag assignTaskToTag(
            @PathVariable Long tagId,
            @PathVariable Long taskId
    )
    {
        Tag tag = tagService.findTagById(tagId);
        Task task = taskService.findTaskById(taskId);
        tag.setTask(task);
        return tagService.getTagRepository().save(tag);
    }

    @PutMapping("/task/{taskId}")
    public List<Tag> getAllTagsByTaskId(@PathVariable Long taskId)
    {
        return tagService.getTagsByTaskId(taskId);
    }

    @PutMapping("/update/{tagId}")
    public void updateTag(
            @PathVariable Long tagId,
            @RequestBody String text
    )
    {
        tagService.updateTag(tagId, text);
    }

    @PutMapping("/delete/{tagId}")
    public void deleteTag(@PathVariable Long tagID)
    {
        tagService.deleteTag(tagID);
    }
}
