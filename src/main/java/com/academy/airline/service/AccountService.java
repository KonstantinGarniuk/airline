package com.academy.airline.service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Discount;
import com.academy.airline.model.entity.Role;

import java.math.BigInteger;

public interface AccountService extends DefaultService<Account, BigInteger> {
    boolean setRole(Account account, Role role);
    boolean setPassword(Account account, String password);
    boolean setDiscount(Account account, Discount discount);
}
