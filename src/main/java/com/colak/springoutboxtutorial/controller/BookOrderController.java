package com.colak.springoutboxtutorial.controller;

import com.colak.springoutboxtutorial.dto.BookOrderDTO;
import com.colak.springoutboxtutorial.service.BookOrderService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Save or update a book order")
    @PostMapping("/saveOrder")
    public void saveOrder(@RequestBody BookOrderDTO bookOrderDTO) {
        bookOrderService.saveOrder(bookOrderDTO);
    }
}
