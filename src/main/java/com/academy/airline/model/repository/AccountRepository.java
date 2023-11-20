package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface AccountRepository extends JpaRepository<Account, BigInteger> {
    Account findByUserName(String userName);
}
