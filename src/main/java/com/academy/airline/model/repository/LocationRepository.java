package com.academy.airline.model.repository;


import com.academy.airline.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<Location> getByCountry(String country);
}
