package com.academy.airline.mapper;

import com.academy.airline.dto.EmployeeDto;
import com.academy.airline.model.entity.Employee;

public class EmployeeMapper {
    private EmployeeMapper(){}
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
            .id(employee.getId())
            .firstName(employee.getAccount().getPerson().getFirstName())
            .lastName(employee.getAccount().getPerson().getLastName())
            .job(employee.getJob().getJob())
            .salary(employee.getSalary())
            .userName(employee.getAccount().getUsername())
            .role(employee.getAccount().getRole().toString())
            .build();
    }
}
