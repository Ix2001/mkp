package com.example.testtask.controllers;

import com.example.testtask.entity.dto.OrderResponseDto;
import com.example.testtask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}/id/get")
    public OrderResponseDto getOrder(
            @PathVariable Long id
    ) {
        return orderService.getOrder(id);
    }
}
