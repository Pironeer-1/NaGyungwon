package week3.week3.board.entity;

import lombok.Builder;
import lombok.Data;
import week3.week3.board.dto.request.BoardUpdateRequest;
import week3.week3.board.dto.response.BoardResponse;

import java.time.LocalDateTime;

@Data
public class Board {
    private Long id;
    private String name;
    private String description;

    @Builder
    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public Board update(BoardUpdateRequest request) {
        this.name = request.name();
        this.description = request.description();
        return this;
    }
}
