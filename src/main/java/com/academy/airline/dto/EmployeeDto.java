package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String job;
    private Integer salary;
    private String userName;
    private String role;
}
