package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentUpdateRequest(@NotNull
                                   @Schema(description = "댓글 ID", example = "1")
                                   Long id,
                                   @NotBlank
                                   @Schema(description = "수정할 댓글 내용", example = "내용을 수정합니다")
                                   String content
                                   ) {
}
