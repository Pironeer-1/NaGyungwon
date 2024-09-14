package com.pironeer.week2.repository;
import com.pironeer.week2.repository.domain.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

//#얘는 토픽만 앎. 다른 클래스는 모름
@Repository
public class TopicRepository {
    private final AtomicLong topicIdxGenerator = new AtomicLong(0);
    private final Map<Long, Topic> topicMap = new HashMap<Long, Topic>();

    public void save(Topic topic) {
        Long id = topicIdxGenerator.incrementAndGet();
        topic.setId(id);
        topicMap.put(id, topic);
    }
    public Topic findById(long id) {
        return topicMap.get(id);
    }
}
