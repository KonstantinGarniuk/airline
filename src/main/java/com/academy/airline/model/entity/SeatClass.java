package com.academy.airline.model.entity;

public enum SeatClass {
    FIRST("First class"),
    ECONOMY("Economy class");

    private String seatClass;

    private SeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatClass() {
        return seatClass;
    }
}
