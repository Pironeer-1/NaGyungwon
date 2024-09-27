package week3.week3.board.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import week3.week3.board.entity.Board;
import week3.week3.topic.entity.Topic;

import java.time.LocalDateTime;

@Builder
public record BoardResponse(
        @NotNull
        @Schema(description = "게시판 ID", example = "1")
        Long id,
        @NotBlank
        @Schema(description = "게시판 제목", example = "제목입니다")
        String name,
        @Schema(description = "게시판 설명", example = "설명입니다")
        String description) {
        public static BoardResponse of(Board board) {
                return BoardResponse.builder()
                        .id(board.getId())
                        .name(board.getName())
                        .description(board.getDescription())
                        .build();
        }
}
