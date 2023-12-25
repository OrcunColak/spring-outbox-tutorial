package com.colak.springoutboxtutorial.service;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;

public interface BookOrderService {

    void placeOrder(BookOrderDTO order);
}
