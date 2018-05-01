package com.gerardoperrucci.gpredbee.controller;


import com.gerardoperrucci.gpredbee.dto.TopicDTO;
import com.gerardoperrucci.gpredbee.model.Topic;
import com.gerardoperrucci.gpredbee.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    /**
     * Create topic
     * @return Topic
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
     * List topic
     * @return
     */
    @GetMapping("/")
    public List<Topic> list() {
        return topicRepository.findAll();
    }


    /**
     * Create topic
     * @return Topic
     */
    @PutMapping("/{id}")
    public Topic update(@RequestBody TopicDTO req) {
        Topic topic = new Topic();
        topic.setInterest(req.getInterest());
        topic.setType(req.getType());
        Topic saved = topicRepository.save(topic);
        return saved;
    }

}
