package week3.week3.board.mapper;

import week3.week3.board.dto.request.BoardCreateRequest;
import week3.week3.board.entity.Board;
import week3.week3.topic.dto.request.TopicCreateRequest;
import week3.week3.topic.entity.Topic;

import java.time.LocalDateTime;

public class BoardMapper {
    public static Board from(BoardCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Board.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }
}
