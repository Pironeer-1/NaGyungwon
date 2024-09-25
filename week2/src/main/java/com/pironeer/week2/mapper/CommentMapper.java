package com.pironeer.week2.mapper;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public class CommentMapper {
    public static Comment from(CommentCreateRequest request, Long topicId) {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
                .content(request.content())
                .topic_id(topicId)
                .parent_id(request.parent_id())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
