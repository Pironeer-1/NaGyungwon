package week3.week3.topic.entity;

import lombok.Builder;
import lombok.Data;
import week3.week3.topic.dto.request.TopicUpdateRequest;

import java.time.LocalDateTime;

@Data
public class Topic {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Topic(
            Long id,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Topic update(TopicUpdateRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
