package week3.week3.topic.mapper;

import week3.week3.topic.dto.request.TopicCreateRequest;
import week3.week3.topic.entity.Topic;

import java.time.LocalDateTime;

public class TopicMapper {
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}