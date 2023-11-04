package com.academy.airline.util.validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DateTimeValidator {
    public static LocalDateTime validateTime(String time, LocalDateTime defaultValue) {
        if(time != null) {
			try {
				return LocalDateTime.parse(time);
			} catch (DateTimeParseException e) {
				System.out.println("Cannot parse time. Set to default value.");
			}
		} else {
			System.out.println("Time is null. Set to default value.");
		}
        return defaultValue;
    }
}
