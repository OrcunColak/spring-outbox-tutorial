package com.colak.springoutboxtutorial.kafkalistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InventoryService {
    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void handleOrderCreatedEvent(@Payload String eventPayload) {
        log.info("Received : {}", eventPayload);
    }
}
