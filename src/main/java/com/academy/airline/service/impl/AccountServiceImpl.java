package com.academy.airline.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.academy.airline.dto.CreateAccountDto;
import com.academy.airline.mapper.CreateAccountMapper;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Discount;
import com.academy.airline.model.entity.Person;
import com.academy.airline.model.entity.Role;
import com.academy.airline.model.repository.AccountRepository;
import com.academy.airline.model.repository.PersonRepository;
import com.academy.airline.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void seveAccount(CreateAccountDto createAccountDto) throws Exception {
        Account account = Account.builder()
            .userName(createAccountDto.getUserName())
            .password(passwordEncoder.encode(createAccountDto.getPassword()))
            .passwordConfirm(passwordEncoder.encode(createAccountDto.getPasswordConfirm()))
            .role(Role.CUSTOMER)
            .discount(Discount.NONE)
            .build();
        Account accountFromBD = accountRepository.findByUserName(account.getUsername());
        if(accountFromBD != null) {
            throw new Exception("Account with this login allready exists");
        }
        if (!createAccountDto.getPassword().equals(createAccountDto.getPasswordConfirm())) {
            throw new Exception("Incorrect password");
        }
        Person person = CreateAccountMapper.mapToPerson(createAccountDto);
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
        accountRepository.save(account);
    }

    
}
