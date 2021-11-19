package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.Status;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        Room room = new Room();

        room.setId(rs.getObject("roomid", UUID.class));
        room.setNumber(rs.getString("number"));
        room.setStatus(Status.valueOf(rs.getString("status")));
        room.setPrice(rs.getInt("roomprice"));
        return room;
    }
}
