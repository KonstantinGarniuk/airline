package com.academy.airline.model.entity;

public enum Discount {
    NONE(0),
    BRONZE(10),
    SILVER(30),
    GOLD(40),
    PLATINUM(50);

    private Integer discountSize;
    private Discount(Integer discount) {
        this.discountSize = discount;
    }
    public Integer getDiscount() {
        return discountSize;
    }
}
