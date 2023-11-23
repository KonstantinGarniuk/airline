package com.academy.airline.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateAccountDto {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String pid;
    private String password;
    private String passwordConfirm;
}
