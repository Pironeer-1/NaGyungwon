package com.pironeer.week2.service;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.mapper.CommentMapper;
import com.pironeer.week2.repository.CommentRepository;
import com.pironeer.week2.repository.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentCreateRequest request, Long topicId) {
        commentRepository.save(CommentMapper.from(request, topicId));
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentResponse::of).toList();
    }

    public CommentResponse update(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.id()).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.save(comment.update(request));
        return CommentResponse.of(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
