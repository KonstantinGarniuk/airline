package com.academy.airline.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.academy.airline.dto.EmployeeDto;
import com.academy.airline.dto.GetEmployeeDto;
import com.academy.airline.mapper.CreateAccountMapper;
import com.academy.airline.mapper.EmployeeMapper;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Crew;
import com.academy.airline.model.entity.Discount;
import com.academy.airline.model.entity.Employee;
import com.academy.airline.model.entity.EmployeeStatus;
import com.academy.airline.model.entity.Job;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.Person;
import com.academy.airline.model.entity.Role;
import com.academy.airline.model.repository.AccountRepository;
import com.academy.airline.model.repository.EmployeeRepository;
import com.academy.airline.model.repository.PersonRepository;
import com.academy.airline.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService { 
    private final EmployeeRepository employeeRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;

    @Override
    public void updateLocation(List<Crew> crew, Location location) {
        List<Employee> employees = new ArrayList<>();
        crew.forEach(emp -> employees.add(emp.getEmployee()));
        employees.forEach(employee -> employee.setLocation(location));
        employeeRepository.saveAll(employees);
    }

    @Override
    public List<EmployeeDto> getEmployeeList(GetEmployeeDto requaredEmployee) {
        List<EmployeeDto> result = new ArrayList<>();
        if (requaredEmployee == null) {
            employeeRepository.findAll().forEach(employee -> result.add(EmployeeMapper.mapToEmployeeDto(employee)));
        } else {
            employeeRepository.getEmployeeList(
                (requaredEmployee.getFirstName() != null) ? requaredEmployee.getFirstName() : "", 
                (requaredEmployee.getLastName() != null) ? requaredEmployee.getLastName() : "", 
                (requaredEmployee.getUserName() != null) ? requaredEmployee.getUserName() : "")
                .forEach(employee -> result.add(EmployeeMapper.mapToEmployeeDto(employee)));
        }
        return result;
    }

    @Override
    public void dismissEmployee(BigInteger id) {
        Employee employee = employeeRepository.getReferenceById(id);
        employee.setJob(Job.DISMISSED);
        Account account = employee.getAccount();
        account.setRole(Role.CUSTOMER);
        employee.setAccount(accountRepository.save(account));
        employeeRepository.save(employee);
    }

    @Override
    public void hireEmployee(HireEmployeeDto employee) throws Exception {
        Optional<Role> role = Stream.of(Role.values())
            .filter(r -> r.toString().equals(employee.getRole()))
            .findFirst();
        Optional<Job> job = Stream.of(Job.values())
            .filter(j -> j.toString().equals(employee.getJob()))
            .findFirst();

        Account account = Account.builder()
            .userName(employee.getUserName())
            .password(passwordEncoder.encode(employee.getPassword()))
            .passwordConfirm(passwordEncoder.encode(employee.getPassword()))
            .discount(Discount.NONE)
            .role((role.isPresent()) ? role.get() : Role.CUSTOMER)
            .build();
        Account accountFromBD = accountRepository.findByUserName(account.getUsername());
        if(accountFromBD != null) {
            throw new Exception("Account with this login allready exists");
        }
        Person person = Person.builder()
            .firstName(employee.getFirstName())
            .lastName(employee.getLastName())
            .dob(employee.getDob())
            .pid(employee.getPid())
            .build();
        Person personFromDb = personRepository.findByPid(person.getPid());
        if (personFromDb == null) {
            personFromDb = personRepository.save(person);
        } else {
            if (!person.getFirstName().equals(personFromDb.getFirstName())
                || !person.getLastName().equals(personFromDb.getLastName()) ) {
                throw new Exception("Person exists, but first or last name is wrong");
            }
        }
        account.setPerson(personFromDb);
        accountFromBD = accountRepository.save(account);
        Employee newEmployee = Employee.builder()
            .account(accountFromBD)
            .salary(employee.getSalary())
            .job((job.isPresent()) ? job.get() : Job.DISPATCHER)
            .status(EmployeeStatus.ACTIVE)
            .build();
        employeeRepository.save(newEmployee);
    }

    

}
