package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
