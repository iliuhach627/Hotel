package com.hotel.dao.model.enums;

import lombok.Getter;

public enum UserStatus {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    @Getter
    private final String role;

    UserStatus(String role) {

        this.role = role;
    }
}
