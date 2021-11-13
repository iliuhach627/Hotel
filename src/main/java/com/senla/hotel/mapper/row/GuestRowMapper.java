package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GuestRowMapper implements RowMapper<Guest> {
    @Override
    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
        Guest guest = new Guest();
        guest.setId(rs.getObject("id", UUID.class));
        guest.setName(rs.getString("name"));
        guest.setSurName(rs.getString("surname"));
        guest.setTel(rs.getString("tel"));
        guest.setAge(rs.getInt("age"));
        guest.setGender(rs.getString("gender"));
        return guest;
    }
}
