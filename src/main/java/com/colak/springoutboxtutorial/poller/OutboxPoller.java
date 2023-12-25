package com.colak.springoutboxtutorial.poller;

import com.colak.springoutboxtutorial.config.KafkaTopicConfig;
import com.colak.springoutboxtutorial.jpa.OutboxEvent;
import com.colak.springoutboxtutorial.repository.OutboxEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OutboxPoller {

    private final OutboxEventRepository outboxEventRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5_000) // Run every 5 seconds
    public void processOutboxEvents() {
        List<OutboxEvent> outboxEvents = outboxEventRepository.findAll();

        for (OutboxEvent outboxEvent : outboxEvents) {
            // Publish events to Kafka
            kafkaTemplate.send(KafkaTopicConfig.ORDER_EVENT_TOPIC, outboxEvent.getEventType(), outboxEvent.getEventPayload());

            // Remove the event from the outbox
            outboxEventRepository.delete(outboxEvent);
        }
    }
}
