package com.example.testtask.service.serviceImpl;

import com.example.testtask.entity.dto.PersonResponseDto;
import com.example.testtask.PersonMapper;
import com.example.testtask.repositories.CourseRepository;
import com.example.testtask.repositories.PersonRepository;
import com.example.testtask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final CourseRepository courseRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper, CourseRepository courseRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public PersonResponseDto getPerson(Long id) {
        var person = personRepository.findById(id).orElseThrow();
        var course = courseRepository.findAllById(person.courses.stream().map(courses -> courses.id).collect(Collectors.toList()));
        return personMapper.toPersonResponseDto(person, course);
    }
}
