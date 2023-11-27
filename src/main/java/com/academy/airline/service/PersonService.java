package com.academy.airline.service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Person;

public interface PersonService {
    void updatePersonInfo(Person person, Account account) throws Exception;
}
