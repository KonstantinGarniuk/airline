package com.academy.airline.model.entity;

public enum TicketStatus {
    BOOKED("Booked"),
    PAID("Paid"),
    USED("Used"),
    CANCELED("Canceled");

    private String status;
    private TicketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}

