package com.gerardoperrucci.gpredbee.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerardoperrucci.gpredbee.dto.TopicDTO;
import com.gerardoperrucci.gpredbee.model.Topic;
import com.gerardoperrucci.gpredbee.repository.TopicRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    /**
     * Create
     */
    @PostMapping("/")
    public Topic create(@RequestBody TopicDTO req) {
        Topic topic = new Topic();
        topic.setInterest(req.getInterest());
        topic.setType(req.getType());
        Topic saved = topicRepository.save(topic);
        return saved;
    }

    /**
     * List
     */
    @GetMapping("/")
    public List<Topic> list() {
        return topicRepository.findAll();
    }

    /**
     * DETAIL
     */
    @GetMapping("/{id}")
    public Topic get(@PathVariable long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (!topic.isPresent())
            return null;

        return topic.get();
    }

    /**
     * REMOVER
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        topicRepository.deleteById(id);
    }


    /**
     * UPDATE
     */
    @PutMapping("/{id}")
    public Topic update(@RequestBody TopicDTO req, @PathVariable long id) {

        Optional<Topic> topicOptional = topicRepository.findById(id);

        if (!topicOptional.isPresent()) return null;

        topicOptional.get().setInterest(req.getInterest());
        topicOptional.get().setType(req.getType());

        return topicRepository.save(topicOptional.get());
    }

}
