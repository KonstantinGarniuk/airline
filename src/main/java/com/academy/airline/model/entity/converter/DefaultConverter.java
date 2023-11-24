package com.academy.airline.model.entity.converter;



import jakarta.persistence.AttributeConverter;

public class DefaultConverter<T extends EnumInfo> implements AttributeConverter<T, String> {

    @Override
    public String convertToDatabaseColumn(T arg0) {
        // if (arg0 == null) {
        //     return null;
        // }
        // return arg0.getStatus();
        return null;
    }

    @Override
    public T convertToEntityAttribute(String arg0) {
        // if (arg0 == null) {
        //     return null;
        // }
        // return Stream.of(T.values())
        //     .filter(status -> status.getStatus().equals(arg0))
        //     .findFirst()
        //     .orElseThrow(IllegalArgumentException::new);
        return null;
    }
}
