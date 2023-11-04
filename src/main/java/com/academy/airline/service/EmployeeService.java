package com.academy.airline.service;

import com.academy.airline.model.entity.Employee;
import com.academy.airline.model.entity.EmployeeStatus;
import com.academy.airline.model.entity.Job;
import com.academy.airline.model.entity.Location;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeService extends DefaultService<Employee, BigInteger>{

    List<Employee> getAvailable(Job job, Location location);
    Integer getSalary(Employee employee);
    boolean setSalary(Employee employee, Integer salary);
    EmployeeStatus getStatus(Employee employee);
    boolean setStatus(Employee employee, EmployeeStatus status);
}
