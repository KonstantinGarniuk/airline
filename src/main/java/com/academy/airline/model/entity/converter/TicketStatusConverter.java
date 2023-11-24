package com.academy.airline.model.entity.converter;

import java.util.stream.Stream;

import com.academy.airline.model.entity.TicketStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TicketStatusConverter implements AttributeConverter<TicketStatus, String>{

    @Override
    public String convertToDatabaseColumn(TicketStatus arg0) {
        if (arg0 == null) {
            return null;
            }
            return arg0.getStatus();
    }

    @Override
    public TicketStatus convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return Stream.of(TicketStatus.values())
            .filter(status -> status.getStatus().equals(arg0))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
    
}
