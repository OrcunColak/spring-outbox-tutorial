package com.colak.springoutboxtutorial.controller;

import com.colak.springoutboxtutorial.dto.OrderDTO;
import com.colak.springoutboxtutorial.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);
    }
}
