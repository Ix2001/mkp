package com.example.testtask;

import com.example.testtask.entity.Courses;
import com.example.testtask.entity.Order;
import com.example.testtask.entity.Person;
import com.example.testtask.entity.dto.CoursesResponseDto;
import com.example.testtask.entity.dto.OrderResponseDto;
import com.example.testtask.entity.dto.PersonResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface PersonMapper {
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "person.name", target = "name")
    @Mapping(source = "person.address", target = "address")
    @Mapping(source = "person.email", target = "email")
    @Mapping(source = "person.orders", target = "orderResponseDto", qualifiedByName = {"provideoOrderResponseDto"})
    @Mapping(source = "coursesList", target = "courses", qualifiedByName = {"provideCourses"})
    PersonResponseDto toPersonResponseDto(Person person, List<Courses> coursesList);

    /*public default List<CoursesResponseDto> provideCourses(List<Courses> courses) {
        return courses.stream().map(courses1 -> new CoursesResponseDto(courses1.getId(), courses1.getName(), courses1.getPerson().stream().map(Person::getId).collect(Collectors.toSet()))).collect(Collectors.toList());
    }*/
    @Named("provideCourses")
    default List<CoursesResponseDto> provideCourses(List<Courses> courses) {
        return courses.stream().map(course -> new CoursesResponseDto(course.getId(), course.getName(), course.getPerson().stream().map(Person::getId).collect(Collectors.toSet()))).collect(Collectors.toList());
    }

    @Named("provideoOrderResponseDto")
    default Set<OrderResponseDto> provideoOrderResponseDto(List<Order> orders)  {
        return orders.stream().map(this::toOrderResponseDto).collect(Collectors.toSet());
    }

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "time", target = "time", qualifiedByName = {"provideTime"})
    @Mapping(source = "order.person.id", target = "userId")
    OrderResponseDto toOrderResponseDto(Order order);

    @Named("provideTime")
    static String provideTime(LocalDateTime localDateTime) {
        return OrderMapper.provideTime(localDateTime);
    }
}
