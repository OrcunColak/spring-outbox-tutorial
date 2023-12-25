package com.colak.springoutboxtutorial.controller;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;
import com.colak.springoutboxtutorial.service.BookOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bookorder")
public class BookOrderController {

    private final BookOrderService bookOrderService;

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody BookOrderDTO bookOrderDTO) {
        bookOrderService.placeOrder(bookOrderDTO);
    }
}
