package com.gerardoperrucci.gpredbee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerardoperrucci.gpredbee.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
