package week3.week3.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateRequest(
        @NotNull
        @Schema(description = "게시판 ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "수정할 게시판 이름", example = "제목을 수정합니다")
        String name,
        @Schema(description = "수정할 게시판 설명", example = "설명을 수정합니다")
        String description
) {
}
