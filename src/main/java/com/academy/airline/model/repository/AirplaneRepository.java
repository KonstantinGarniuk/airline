package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airplane;
import com.academy.airline.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
