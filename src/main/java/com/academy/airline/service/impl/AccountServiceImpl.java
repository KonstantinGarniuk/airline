package com.academy.airline.service.impl;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Role;
import com.academy.airline.model.repository.AccountRepository;
import com.academy.airline.model.repository.RoleRepository;
import com.academy.airline.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Override
    public boolean seveAccount(Account account) {
        Account accontFromBb = accountRepository.findByUserName(account.getUsername());
        if (accontFromBb != null) {
            return false;
        }

        if (account.getRole() == null) {
            Role role = roleRepository.findByRole("ROLE_CUSTOMER");
            account.setRole(role);
        }

        accountRepository.save(account);
        return true; 
    }
    
}
