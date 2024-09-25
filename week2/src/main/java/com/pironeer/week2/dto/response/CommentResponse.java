package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Topic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import com.pironeer.week2.repository.domain.Comment;
import java.time.LocalDateTime;

@Builder
public record CommentResponse( @Schema(description = "댓글 ID", example = "1")
                               Long id,
                               @Schema(description = "댓글 내용", example = "내용입니다")
                               String content,
                               @Schema(description = "댓글 생성 시간", example = "2024-10-10 10:10:00")
                               LocalDateTime createdAt,
                               @Schema(description = "댓글 수정 시간", example = "2024-10-13 10:10:00")
                               LocalDateTime updatedAt,
                               @Schema(description = "부모 댓글 ID", example = "1")
                               Long parent_id,
                               @Schema(description = "부모 Topic ID", example = "1")
                               Long topic_id
) {
    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .parent_id(comment.getParent_id())
                .topic_id(comment.getTopic_id())
                .build();
    }
}
