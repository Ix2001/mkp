package com.example.testtask.service.serviceImpl;

import com.example.testtask.entity.dto.OrderResponseDto;
import com.example.testtask.OrderMapper;
import com.example.testtask.repositories.OrderRepository;
import com.example.testtask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDto getOrder(Long id) {
       var order = orderRepository.findById(id).orElseThrow();
       return orderMapper.toOrderResponseDto(order);
    }
}
