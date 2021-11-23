package com.senla.hotel.model;

import com.senla.hotel.model.enums.UserStatus;
import lombok.Data;

import java.util.Collection;

@Data
public class User extends BaseEntity {
    private String name;
    private Collection<UserStatus> userStatus;
    private String password;
}
