package com.example.testtask.entity.dto;

import lombok.Data;


@Data
public class OrderResponseDto {
    public Long orderId;
    public String name;
    public String time;
    public Long userId;
}
