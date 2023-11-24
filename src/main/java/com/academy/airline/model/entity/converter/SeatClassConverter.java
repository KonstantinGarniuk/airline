package com.academy.airline.model.entity.converter;

import java.util.stream.Stream;

import com.academy.airline.model.entity.SeatClass;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SeatClassConverter implements AttributeConverter<SeatClass, String> {

    @Override
    public String convertToDatabaseColumn(SeatClass arg0) {
        if (arg0 == null) {
            return null;
            }
            return arg0.getSeatClass();
    }

    @Override
    public SeatClass convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return Stream.of(SeatClass.values())
            .filter(status -> status.getSeatClass().equals(arg0))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
}
