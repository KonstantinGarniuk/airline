package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, BigInteger> {
    @Query("from Employee where account.person.firstName like CONCAT('%',:firstName,'%') and account.person.lastName like CONCAT('%',:lastName,'%') and account.userName like CONCAT('%',:userName,'%') and job <> Job.DISMISSED")
    List<Employee> getEmployeeList(String firstName, String lastName, String userName);
}
