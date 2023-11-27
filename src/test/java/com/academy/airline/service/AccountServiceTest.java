package com.academy.airline.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.academy.airline.dto.CreateAccountDto;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Person;
import com.academy.airline.model.repository.AccountRepository;
import com.academy.airline.model.repository.PersonRepository;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void addAccount_succsess(){
        CreateAccountDto accountDto = CreateAccountDto.builder()
            .userName("testAccountName")
            .firstName("testFirstName")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertDoesNotThrow(() -> accountService.seveAccount(accountDto), "Errors while saving account");
        Account account = accountRepository.findByUserName("testAccountName");
        assertNotNull(account, "Cannot find account in DB");
    }

    @Test
    void addAccount_thouwsException_passwordMismatch() {
        CreateAccountDto accountDto = CreateAccountDto.builder()
            .userName("testAccountName")
            .firstName("testFirstName")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass2")
            .passwordConfirm("testPass")
            .build();
        assertThrows(Exception.class, () -> accountService.seveAccount(accountDto), "Should throw Exception because of passwords mismatch");
    }

    @Test 
    void addAccount_throwsException_accountExists() {
        CreateAccountDto accountDto = CreateAccountDto.builder()
            .userName("testAccountName")
            .firstName("testFirstName")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertDoesNotThrow(() -> accountService.seveAccount(accountDto), "Errors while saving account");
        assertThrows(Exception.class, () -> accountService.seveAccount(accountDto), "Should throw Exception because same user name");
    }

    @Test
    void addAccount_throwsEsception_firsNameMismutch() {
        CreateAccountDto accountDto = CreateAccountDto.builder()
            .userName("testAccountName")
            .firstName("testFirstName")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertDoesNotThrow(() -> accountService.seveAccount(accountDto), "Errors while saving account");
        CreateAccountDto accountDto1 = CreateAccountDto.builder()
            .userName("testAccountName1")
            .firstName("testFirstName1")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertThrows(Exception.class, () -> accountService.seveAccount(accountDto1), "Should throw Exception because person first name mismutch");
    }
    @Test
    void addAccount_throwsEsception_lastNameMismutch() {
        CreateAccountDto accountDto = CreateAccountDto.builder()
            .userName("testAccountName")
            .firstName("testFirstName")
            .lastName("testLastName")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertDoesNotThrow(() -> accountService.seveAccount(accountDto), "Errors while saving account");
        CreateAccountDto accountDto1 = CreateAccountDto.builder()
            .userName("testAccountName1")
            .firstName("testFirstName")
            .lastName("testLastName1")
            .pid("testPid9999")
            .dob(LocalDate.of(1992, 10, 12))
            .password("testPass")
            .passwordConfirm("testPass")
            .build();
        assertThrows(Exception.class, () -> accountService.seveAccount(accountDto1), "Should throw Exception because person last name mismutch");
    }

    @AfterEach
    void cleanUp() {
        Account account = accountRepository.findByUserName("testAccountName");
        if(account != null) {
            accountRepository.deleteById(account.getId());
        }
        Person person = personRepository.findByPid("testPid9999");
        if(person != null) {
            personRepository.deleteById(person.getId());
        }
    }
}
