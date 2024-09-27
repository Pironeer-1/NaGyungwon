package week3.week3.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week3.week3.board.dto.request.BoardCreateRequest;
import week3.week3.board.dto.request.BoardUpdateRequest;
import week3.week3.board.dto.response.BoardResponse;
import week3.week3.board.entity.Board;
import week3.week3.board.mapper.BoardMapper;
import week3.week3.board.repository.BoardRepository;
import week3.week3.global.dto.response.result.ListResult;
import week3.week3.global.dto.response.result.SingleResult;
import week3.week3.global.exception.CustomException;
import week3.week3.global.exception.ErrorCode;
import week3.week3.global.service.ResponseService;
import week3.week3.topic.dto.request.TopicUpdateRequest;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public SingleResult<Long> save(BoardCreateRequest request) {
        Board savedBoard = boardRepository.save(BoardMapper.from(request));
        return ResponseService.getSingleResult(savedBoard.getId());
    }

    public SingleResult<BoardResponse> findById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        BoardResponse boardResponse = BoardResponse.of(board);
        return ResponseService.getSingleResult(boardResponse);
    }

    public ListResult<BoardResponse> findAll() {
        List<Board> topics = boardRepository.findAll();
        List<BoardResponse> list = topics.stream().map(BoardResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public BoardResponse update(BoardUpdateRequest request) {
        Board board = boardRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        boardRepository.save(board.update(request));
        return BoardResponse.of(board);
    }

    public Long deleteById(Long id) {
        Long deleteId = boardRepository.deleteById(id);
        return deleteId;
    }
}
