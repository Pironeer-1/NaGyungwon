package week3.week3.topic.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import week3.week3.global.dto.response.SuccessResponse;
import week3.week3.global.dto.response.result.ListResult;
import week3.week3.global.dto.response.result.SingleResult;
import week3.week3.topic.dto.request.TopicCreateRequest;
import week3.week3.topic.dto.request.TopicUpdateRequest;
import week3.week3.topic.dto.response.TopicResponse;
import week3.week3.topic.service.TopicService;

@RestController
@RequiredArgsConstructor
@Tag(name = "게시물(Topic)")
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    @Operation(summary = "게시물 작성")
    public SuccessResponse<SingleResult<Long>> create(
            @RequestAttribute("id") String userId,
            @Valid @RequestBody TopicCreateRequest request
    ) {
        System.out.println(userId);

        SingleResult<Long> save = topicService.save(request);
        return SuccessResponse.ok(save);
    }

    @GetMapping("/{topicId}")
    @Operation(summary = "게시물 단건 조회")
    public SuccessResponse<SingleResult<TopicResponse>> read(@PathVariable("topicId") Long id) {
        SingleResult<TopicResponse> result = topicService.findById(id);
        return SuccessResponse.ok(result);
    }

    @GetMapping
    @Operation(summary = "게시물 전체 조회")
    public SuccessResponse<ListResult<TopicResponse>> readAll() {
        ListResult<TopicResponse> result = topicService.findAll();
        return SuccessResponse.ok(result);
    }

    @PutMapping
    @Operation(summary = "게시물 수정")
    public ResponseEntity<TopicResponse> update(@Valid @RequestBody TopicUpdateRequest request) {
        TopicResponse response = topicService.update(request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{topicId}")
    @Operation(summary = "게시물 삭제")
    public ResponseEntity<Long> remove(@PathVariable("topicId") Long id) {
        Long deletedId = topicService.deleteById(id);
        return ResponseEntity.ok().body(deletedId);
    }
}
