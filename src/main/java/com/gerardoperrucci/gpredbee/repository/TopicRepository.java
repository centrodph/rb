package com.gerardoperrucci.gpredbee.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerardoperrucci.gpredbee.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
