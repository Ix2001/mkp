package com.example.testtask.entity.dto;

import lombok.Data;

import java.util.Set;
import java.util.stream.Stream;

@Data
public class CoursesResponseDto {
    public Long id;
    public String name;
    public Set<Long> personId;

    public CoursesResponseDto(Long id, String name, Set<Long> personId) {
        this.id = id;
        this.name = name;
        this.personId = personId;
    }
}