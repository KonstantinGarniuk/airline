package com.academy.airline.model.entity;

public enum EmployeeStatus {
    ACTIVE("Active"),
    REST("Rest"),
    ILLNESS("Illness"),
    VACATION("Vacation");

    private String status;
    private EmployeeStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
