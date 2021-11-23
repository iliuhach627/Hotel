package com.senla.hotel.mapper.row;

import com.senla.hotel.model.User;
import com.senla.hotel.model.enums.UserStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getObject("userid", UUID.class));
        user.setName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setUserStatus(getRoles( rs.getString("userstatus")));
        return user;
    }

    private Collection<UserStatus> getRoles(String roles) {
        return roles.contains("[") ? Arrays.stream(roles.substring(1, roles.length() - 1).split(", "))
                .map(UserStatus::valueOf)
                .collect(Collectors.toList())
                : Collections.singletonList(UserStatus.valueOf(roles));
    }
}
