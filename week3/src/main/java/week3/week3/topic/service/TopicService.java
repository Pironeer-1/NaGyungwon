package week3.week3.topic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week3.week3.global.dto.response.result.ListResult;
import week3.week3.global.dto.response.result.SingleResult;
import week3.week3.global.exception.CustomException;
import week3.week3.global.exception.ErrorCode;
import week3.week3.global.service.ResponseService;
import week3.week3.topic.dto.request.TopicCreateRequest;
import week3.week3.topic.dto.request.TopicUpdateRequest;
import week3.week3.topic.dto.response.TopicResponse;
import week3.week3.topic.entity.Topic;
import week3.week3.topic.mapper.TopicMapper;
import week3.week3.topic.repository.TopicRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public SingleResult<Long> save(TopicCreateRequest request) {
        Topic savedTopic = topicRepository.save(TopicMapper.from(request));
        return ResponseService.getSingleResult(savedTopic.getId());
    }

    public SingleResult<TopicResponse> findById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        TopicResponse topicResponse = TopicResponse.of(topic);
        return ResponseService.getSingleResult(topicResponse);
    }

    public ListResult<TopicResponse> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicResponse> list = topics.stream().map(TopicResponse::of).toList();
        return ResponseService.getListResult(list);
    }

    public TopicResponse update(TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("TOPIC NOT FOUND"));
        topicRepository.save(topic.update(request));
        return TopicResponse.of(topic);
    }

    public Long deleteById(Long id) {
        Long deleteId = topicRepository.deleteById(id);
        return deleteId;
    }
}
