package com.colak.springoutboxtutorial.service;

import com.colak.springoutboxtutorial.dto.OrderDTO;

public interface OrderService {

    void placeOrder(OrderDTO order);
}
