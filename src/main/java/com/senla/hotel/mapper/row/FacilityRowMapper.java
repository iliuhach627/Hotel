package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Facility;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class FacilityRowMapper implements RowMapper<Facility> {
    @Override
    public Facility mapRow(ResultSet rs, int rowNum) throws SQLException {
        Facility facility = new Facility();
        facility.setId(rs.getObject("facilityid", UUID.class));
        facility.setTitle(rs.getString("title"));
        facility.setPrice(rs.getInt("facilityprice"));
        return facility;
    }
}
