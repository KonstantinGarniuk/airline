package com.academy.airline.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Crew;
import com.academy.airline.model.entity.Employee;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.EmployeeRepository;
import com.academy.airline.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService { 
    private final EmployeeRepository employeeRepository;

    @Override
    public void updateLocation(List<Crew> crew, Location location) {
        List<Employee> employees = new ArrayList<>();
        crew.forEach(emp -> employees.add(emp.getEmployee()));
        employees.forEach(employee -> employee.setLocation(location));
        employeeRepository.saveAll(employees);
    }

    

}
