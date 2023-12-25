package com.colak.springoutboxtutorial.service.impl;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;
import com.colak.springoutboxtutorial.jpa.BookOrder;
import com.colak.springoutboxtutorial.jpa.OutboxEvent;
import com.colak.springoutboxtutorial.repository.OrderRepository;
import com.colak.springoutboxtutorial.repository.OutboxEventRepository;
import com.colak.springoutboxtutorial.service.BookOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookOrderServiceImpl implements BookOrderService {

    private final OrderRepository orderRepository;

    private final OutboxEventRepository outboxEventRepository;

    @Transactional
    @Override
    public void placeOrder(BookOrderDTO bookOrderDTO) {
        saveBookOrder(bookOrderDTO);
        saveOutboxEvent(bookOrderDTO);
    }

    private void saveBookOrder(BookOrderDTO bookOrderDTO) {
        BookOrder bookOrder = new BookOrder();
        bookOrder.setOrderId(bookOrder.getOrderId());
        bookOrder.setCustomerId(bookOrderDTO.getCustomerId());
        orderRepository.save(bookOrder);
    }

    private void saveOutboxEvent(BookOrderDTO bookOrderDTO) {
        // Generate OrderCreated event
        String eventPayload = buildOrderCreatedEventPayload(bookOrderDTO);

        // Save the event to the outbox within the same transaction
        OutboxEvent outboxEvent = new OutboxEvent();
        outboxEvent.setEventType("OrderCreated");
        outboxEvent.setEventPayload(eventPayload);
        outboxEventRepository.save(outboxEvent);
    }

    private String buildOrderCreatedEventPayload(BookOrderDTO bookOrderDTO) {
        // Logic to construct the event payload
        // Include relevant information like order ID, customer details, etc.
        return bookOrderDTO.toString();
    }
}
