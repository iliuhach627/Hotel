package com.senla.hotel.model;

import com.senla.hotel.model.enums.UserStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    private Collection<UserStatus> userStatus;
    private String password;
}
