package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        Room room = new Room();

        room.setId(rs.getObject("id", UUID.class));
        room.setNumber(rs.getString("number"));
        room.setStatus(Status.valueOf(rs.getString("status")));
        room.setPrice(rs.getInt("price"));
        return room;
    }
}
