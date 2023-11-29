package com.academy.airline.service.impl;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HireEmployeeDto {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String pid;
    private String userName;
    private String password;
    private String role;
    private String job;
    private Integer salary;
}
