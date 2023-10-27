package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EmployeeRepository  extends JpaRepository<Employee, BigInteger> {
}
