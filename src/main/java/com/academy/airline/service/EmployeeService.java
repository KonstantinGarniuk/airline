package com.academy.airline.service;

import java.util.List;

import com.academy.airline.model.entity.Crew;
import com.academy.airline.model.entity.Location;


public interface EmployeeService{
    void updateLocation(List<Crew> crew, Location location); 
}
