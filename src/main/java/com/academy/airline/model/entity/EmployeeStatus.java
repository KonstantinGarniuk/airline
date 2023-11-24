package com.academy.airline.model.entity;

import com.academy.airline.model.entity.converter.EnumInfo;

public enum EmployeeStatus implements EnumInfo {
    ACTIVE("Active"),
    REST("Rest"),
    ILLNESS("Illness"),
    VACATION("Vacation");

    private String status;
    private EmployeeStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
