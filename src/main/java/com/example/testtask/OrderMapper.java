package com.example.testtask;

import com.example.testtask.entity.Order;
import com.example.testtask.entity.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface OrderMapper {
    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "time", target = "time", qualifiedByName = {"provideTime"})
    @Mapping(source = "order.person.id", target = "userId")
    OrderResponseDto toOrderResponseDto(Order order);

    @Named("provideTime")
    static String provideTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd-MM-yyyy HH:mm");
        return localDateTime.format(formatter);
    }
}