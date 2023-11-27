package com.academy.airline.mapper;

import com.academy.airline.dto.AccountDto;
import com.academy.airline.model.entity.Account;

public class AccountMapper {
    private AccountMapper(){}

    public static AccountDto mapToAccountDto(Account account){
        return AccountDto.builder()
            .userName(account.getUsername())
            .firstName(account.getPerson().getFirstName())
            .lastName(account.getPerson().getLastName())
            .dob(account.getPerson().getDob())
            .pid(account.getPerson().getPid())
            .role(account.getRole().getAuthority())
            .discount(account.getDiscount().getDiscount())
            .build();
    }
}
