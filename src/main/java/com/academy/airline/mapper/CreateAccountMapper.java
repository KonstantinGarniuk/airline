package com.academy.airline.mapper;

import com.academy.airline.dto.CreateAccountDto;
import com.academy.airline.model.entity.Person;

public class CreateAccountMapper {
    
    public static Person mapToPerson(CreateAccountDto createAccountDto) {
        return Person.builder()
            .firstName(createAccountDto.getFirstName())
            .lastName(createAccountDto.getLastName())
            .dob(createAccountDto.getDob())
            .pid(createAccountDto.getPid())
            .build();
    } 
}
