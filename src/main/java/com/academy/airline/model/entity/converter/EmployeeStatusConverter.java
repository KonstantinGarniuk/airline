package com.academy.airline.model.entity.converter;

import java.util.stream.Stream;

import com.academy.airline.model.entity.EmployeeStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, String> {

    @Override
    public String convertToDatabaseColumn(EmployeeStatus arg0) {
        if (arg0 == null) {
            return null;
            }
            return arg0.getStatus();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return Stream.of(EmployeeStatus.values())
            .filter(status -> status.getStatus().equals(arg0))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
}
