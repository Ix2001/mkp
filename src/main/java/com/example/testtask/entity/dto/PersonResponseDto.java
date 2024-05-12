package com.example.testtask.entity.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PersonResponseDto {
    public Long personId;
    public String name;
    public String address;
    public String email;
    public Set<OrderResponseDto> orderResponseDto;
    public List<CoursesResponseDto> courses;
}
