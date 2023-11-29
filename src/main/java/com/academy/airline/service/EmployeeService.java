package com.academy.airline.service;

import java.math.BigInteger;
import java.util.List;

import com.academy.airline.dto.EmployeeDto;
import com.academy.airline.dto.GetEmployeeDto;
import com.academy.airline.model.entity.Crew;
import com.academy.airline.model.entity.Location;
import com.academy.airline.service.impl.HireEmployeeDto;


public interface EmployeeService{
    void updateLocation(List<Crew> crew, Location location);
    List<EmployeeDto> getEmployeeList(GetEmployeeDto requaredEmployee);
    void dismissEmployee(BigInteger id);
    void hireEmployee(HireEmployeeDto employee) throws Exception;
}
