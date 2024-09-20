package com.pironeer.week2.repository.domain;

import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Long topic_id;
    private Long parent_id;

    @Builder
    public Comment(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Long topic_id, Long parent_id) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.topic_id = topic_id;
        this.parent_id = parent_id;
    }

    public Comment update(CommentUpdateRequest request) {
        this.content = request.content();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
