package com.hotel.dao.model;

import com.hotel.dao.model.enums.UserStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String password;
}
