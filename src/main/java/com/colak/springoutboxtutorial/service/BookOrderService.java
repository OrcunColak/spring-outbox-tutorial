package com.colak.springoutboxtutorial.service;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;

public interface BookOrderService {

    void saveOrder(BookOrderDTO order);
}
