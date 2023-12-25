package com.colak.springoutboxtutorial.service.impl;

import com.colak.springoutboxtutorial.dto.OrderDTO;
import com.colak.springoutboxtutorial.jpa.OutboxEvent;
import com.colak.springoutboxtutorial.repository.OutboxEventRepository;
import com.colak.springoutboxtutorial.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OutboxEventRepository outboxEventRepository;

    @Transactional
    @Override
    public void placeOrder(OrderDTO orderDTO) {
        // Business logic to process the order and update the order status

        // Generate OrderCreated event
        String eventPayload = buildOrderCreatedEventPayload(orderDTO);

        // Save the event to the outbox within the same transaction
        OutboxEvent outboxEvent = new OutboxEvent();
        outboxEvent.setEventType("OrderCreated");
        outboxEvent.setEventPayload(eventPayload);
        outboxEventRepository.save(outboxEvent);
    }

    private String buildOrderCreatedEventPayload(OrderDTO orderDTO) {
        // Logic to construct the event payload
        // Include relevant information like order ID, customer details, etc.
        return orderDTO.toString();
    }
}
