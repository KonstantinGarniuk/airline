package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PersonRepository extends JpaRepository<Person, BigInteger> {
    public Person findByPid(String pid);
}
