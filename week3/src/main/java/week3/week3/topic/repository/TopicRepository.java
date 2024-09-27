package week3.week3.topic.repository;

import week3.week3.topic.entity.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {

    Topic save(Topic topic);

    Optional<Topic> findById(Long id);

    List<Topic> findAll();

    Long deleteById(Long id);
}
