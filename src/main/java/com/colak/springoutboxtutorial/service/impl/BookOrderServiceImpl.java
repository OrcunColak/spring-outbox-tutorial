package com.colak.springoutboxtutorial.service.impl;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;
import com.colak.springoutboxtutorial.jpa.BookOrder;
import com.colak.springoutboxtutorial.jpa.OutboxEvent;
import com.colak.springoutboxtutorial.mapstruct.BookOrderMapper;
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
    public void saveOrder(BookOrderDTO bookOrderDTO) {
        saveBookOrder(bookOrderDTO);
        saveOutboxEvent(bookOrderDTO);
    }

    private void saveBookOrder(BookOrderDTO bookOrderDTO) {
        BookOrderMapper mapper = BookOrderMapper.INSTANCE;
        BookOrder bookOrder = mapper.dtoToBookOrder(bookOrderDTO);

        orderRepository.save(bookOrder);
    }

    private void saveOutboxEvent(BookOrderDTO bookOrderDTO) {
        String eventPayload = buildEventPayload(bookOrderDTO);

        // Save the event to the outbox within the same transaction
        OutboxEvent outboxEvent = new OutboxEvent();
        outboxEvent.setEventType("BookOrderSaved");
        outboxEvent.setEventPayload(eventPayload);
        outboxEventRepository.save(outboxEvent);
    }

    private String buildEventPayload(BookOrderDTO bookOrderDTO) {
        return bookOrderDTO.toString();
    }
}
