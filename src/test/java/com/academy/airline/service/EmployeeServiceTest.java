package com.academy.airline.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.academy.airline.dto.GetEmployeeDto;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEpmloyees_fullInputData_notEmptyResult() {
        GetEmployeeDto employeeInfo = new GetEmployeeDto();
        employeeInfo.setFirstName("test");
        employeeInfo.setLastName("test");
        employeeInfo.setUserName("test");
        assertNotEquals(0, employeeService.getEmployeeList(employeeInfo).size(), "Result is empty");
    }

    @Test
    void getEpmloyees_firstNameNull_notEmptyResult() {
        GetEmployeeDto employeeInfo = new GetEmployeeDto();
        employeeInfo.setLastName("test");
        employeeInfo.setUserName("test");
        assertNotEquals(0, employeeService.getEmployeeList(employeeInfo).size(), "Result is empty");
    }

    @Test
    void getEpmloyees_firstNameAndLastNAmeNull_notEmptyResult() {
        GetEmployeeDto employeeInfo = new GetEmployeeDto();
        employeeInfo.setUserName("test");
        assertNotEquals(0, employeeService.getEmployeeList(employeeInfo).size(), "Result is empty");
    }

    @Test
    void getEpmloyees_AllNull_notEmptyResult() {
        assertNotEquals(0, employeeService.getEmployeeList(new GetEmployeeDto()).size(), "Result is empty");
    }

    @Test
    void getEpmloyees_nullDto_notEmptyResult() {
        assertNotEquals(0, employeeService.getEmployeeList(null).size(), "Result is empty");
    }
}
