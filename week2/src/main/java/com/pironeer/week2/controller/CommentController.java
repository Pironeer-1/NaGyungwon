package com.pironeer.week2.controller;

import com.pironeer.week2.dto.request.CommentCreateRequest;
import com.pironeer.week2.dto.request.CommentUpdateRequest;
import com.pironeer.week2.dto.request.TopicUpdateRequest;
import com.pironeer.week2.dto.response.CommentResponse;
import com.pironeer.week2.dto.response.TopicResponse;
import com.pironeer.week2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "댓글(Comment)")
@RequestMapping("/api/topic/{topicId}/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> create(@Valid @RequestBody CommentCreateRequest request, @PathVariable("topicId") Long topicId) {
        commentService.save(request, topicId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "댓글 전체 조회")
    public ResponseEntity<List<CommentResponse>> readAll() {
        List<CommentResponse> responses = commentService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<CommentResponse> update(@Valid @RequestBody CommentUpdateRequest request) {
        CommentResponse response = commentService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> remove(@PathVariable("commentId") Long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
