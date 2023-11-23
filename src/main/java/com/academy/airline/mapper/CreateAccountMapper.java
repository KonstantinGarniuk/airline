package com.academy.airline.mapper;

import com.academy.airline.dto.CreateAccountDto;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Person;

public class CreateAccountMapper {
    public static Account mapToAccount(CreateAccountDto createAccountDto) {
        return Account.builder()
            .userName(createAccountDto.getUserName())
            .password(createAccountDto.getPassword())
            .passwordConfirm(createAccountDto.getPasswordConfirm())
            .build();
    }

    public static Person mapToPerson(CreateAccountDto createAccountDto) {
        return Person.builder()
            .firstName(createAccountDto.getFirstName())
            .lastName(createAccountDto.getLastName())
            .dob(createAccountDto.getDob())
            .pid(createAccountDto.getPid())
            .build();
    } 
}
