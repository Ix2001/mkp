package com.example.testtask.service;

import com.example.testtask.entity.dto.OrderResponseDto;

public interface OrderService {
    public OrderResponseDto getOrder(Long id);
}
