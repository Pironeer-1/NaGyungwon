package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CommentCreateRequest(@NotBlank
                                   @Schema(description = "댓글 내용", example = "댓글입니다")
                                   String content,
                                   @Schema(description = "부모 댓글 ID", example = "1")
                                   Long parent_id) {
    public CommentCreateRequest(String content) {
        this(content, null); // 기본은 Null, 부모 아이디가 전달될 때만 대댓글 처리하도록
    }
}
