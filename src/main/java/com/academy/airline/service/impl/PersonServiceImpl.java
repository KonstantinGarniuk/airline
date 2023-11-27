package com.academy.airline.service.impl;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Person;
import com.academy.airline.model.repository.PersonRepository;
import com.academy.airline.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Override
    public void updatePersonInfo(Person person, Account account) throws Exception {
        Person personFromDb = personRepository.findByPid(person.getPid());
        if (personFromDb != null) {
            if (account.getPerson().getId() != personFromDb.getId()) {
                throw new Exception("Person with such pid allready exists. Cannot move account to existing Person");
            }
        }
        person.setId(account.getPerson().getId());
        account.setPerson(personRepository.save(person));
    }
    
}
