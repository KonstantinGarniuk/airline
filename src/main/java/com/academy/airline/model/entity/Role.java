package com.academy.airline.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CUSTOMER("ROLE_CUSTOMER"),
    MANAGER("ROLE_MANAGER"),
    DISPATCHER("ROLE_DISPATCHER"),
    HR("ROLE_HR");

    private String authority;
    private Role(String role) {
        this.authority = role;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
