package com.academy.airline.model.entity.converter;

import java.util.stream.Stream;

import com.academy.airline.model.entity.AirplaneStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AirplaneStatusConverter implements AttributeConverter<AirplaneStatus, String>{

    @Override
    public String convertToDatabaseColumn(AirplaneStatus arg0) {
        if (arg0 == null) {
        return null;
        }
        return arg0.getStatus();
    }

    @Override
    public AirplaneStatus convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return Stream.of(AirplaneStatus.values())
            .filter(status -> status.getStatus().equals(arg0))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
}
