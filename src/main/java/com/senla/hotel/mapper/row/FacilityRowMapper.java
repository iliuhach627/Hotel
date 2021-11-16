package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Facility;
import com.senla.hotel.model.Guest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FacilityRowMapper implements RowMapper<Facility> {
    @Override
    public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
        Facility facility = new Facility();
        facility.setId(rs.getObject("id", UUID.class));
        facility.setTitle(rs.getString("title"));
        facility.setPrice(rs.getInt("price"));
        return facility;
    }
}
