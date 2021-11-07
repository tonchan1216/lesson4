package com.example.lesson4.domain.repository;

import com.example.lesson4.domain.model.SampleQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgRepositoryImpl implements MsgRepository {
    @Value("${amazon.queue.name}")
    private String queueName;

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Override
    public void save(SampleQueue sampleQueue) {
        queueMessagingTemplate.convertAndSend(queueName, sampleQueue.getMessage());
    }
}
