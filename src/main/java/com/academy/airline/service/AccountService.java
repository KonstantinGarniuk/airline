package com.academy.airline.service;

import com.academy.airline.dto.CreateAccountDto;


public interface AccountService {
    void seveAccount(CreateAccountDto createAccountDto) throws Exception;
}
