package com.academy.airline.model.entity.converter;

import java.util.stream.Stream;

import com.academy.airline.model.entity.FlightStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FlightStatusConverter implements AttributeConverter<FlightStatus, String> {

    @Override
    public String convertToDatabaseColumn(FlightStatus arg0) {
        if (arg0 == null) {
            return null;
            }
            return arg0.getStatus();
    }

    @Override
    public FlightStatus convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return Stream.of(FlightStatus.values())
            .filter(status -> status.getStatus().equals(arg0))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
}
