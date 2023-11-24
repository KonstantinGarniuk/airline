package com.academy.airline.model.entity;

public enum FlightStatus {
    GETTING_READY("Getting ready"),
    BOARDING("Boarding"),
    IN_MID_COURCE("In mid cource"),
    LANDED("Landed"),
    LATE("Late"),
    CANCELED("Canceled");

    private String status;
    private FlightStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
