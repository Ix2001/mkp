package com.example.testtask.service;

import com.example.testtask.entity.dto.PersonResponseDto;

public interface PersonService {
    public PersonResponseDto getPerson(Long id);
}
