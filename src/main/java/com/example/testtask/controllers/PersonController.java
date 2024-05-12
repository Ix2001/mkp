package com.example.testtask.controllers;

import com.example.testtask.entity.dto.PersonResponseDto;
import com.example.testtask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/{id}/id/get")
    public PersonResponseDto getPerson(
            @PathVariable Long id
    ) {
        return personService.getPerson(id);
    }
}
