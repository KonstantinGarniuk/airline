package com.academy.airline.model.entity;

public enum AirplaneStatus {
    READY("Ready"),
    FLIGHT("Flight"),
    SERVICE("Service"),
    REFUELING("Refueling");

    private String status;

    private AirplaneStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
