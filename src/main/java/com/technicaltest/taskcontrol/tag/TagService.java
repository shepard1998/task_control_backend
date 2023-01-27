package com.technicaltest.taskcontrol.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService
{
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags()
    {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByTaskId(Long id)
    {
        return tagRepository.findAllByTaskId(id);
    }

    public Tag findTagById(Long id)
    {
        return tagRepository.findTagById(id).get();
    }

    public void addNewTag(Tag tag)
    {
        tagRepository.save(tag);
    }

    public void updateTag(long id, String text)
    {
        Tag tagToUpdate = tagRepository.findTagById(id).get();
        tagToUpdate.setText(text);
        tagRepository.save(tagToUpdate);
    }

    public void deleteTag(Long id)
    {
        tagRepository.deleteById(id);
    }

    public TagRepository getTagRepository() {
        return tagRepository;
    }

}
