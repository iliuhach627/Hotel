package com.senla.hotel.repository;

import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.mapper.row.RoomRowMapper;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.Status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
public class RoomDaoImpl implements RoomDao {

    private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into room (roomid, number, status, roomprice) values (?, ?, ?, ?)";
    private static final String findAllSQL = "select * from room";
    private static final String findByIdSQL = "select * from room where roomid = ?";
    private static final String deleteSQL = "delete from room where roomid = ?";
    private static final String updateSQL = "update room set number = ?, status = ?, roomprice = ? where roomid = ?";

    public RoomDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Room save(Room room) {
        if (Objects.isNull(room.getId())) {
            room.setId(UUID.randomUUID());
            room.setStatus(Status.FREE);
            jdbcTemplate.update(createSQL, room.getId(), room.getNumber(), room.getStatus().toString(), room.getPrice());
        } else {
            jdbcTemplate.update(updateSQL, room.getNumber(), room.getStatus().toString(), room.getPrice(), room.getId());
        }
        return room;
    }

    @Override
    public Collection<Room> findAll() {
        return jdbcTemplate.query(findAllSQL, new RoomRowMapper());
    }

    @Override
    public Room findById(UUID id) {

        return jdbcTemplate.queryForObject(findByIdSQL, new RoomRowMapper(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }

    @Override
    public Room changeStatus(Room room) {
        if (room.getStatus().equals(Status.FREE)) {
            room.setStatus(Status.REPAIRED);
            jdbcTemplate.update(updateSQL, room.getNumber(), room.getStatus().toString(), room.getPrice(), room.getId());
        } else if (room.getStatus().equals(Status.REPAIRED)) {
            room.setStatus(Status.FREE);
            jdbcTemplate.update(updateSQL, room.getNumber(), room.getStatus().toString(), room.getPrice(), room.getId());
        }
        return room;
    }

    @Override
    public Room autoChangeStatus(Room room) {
        if (room.getStatus().equals(Status.FREE)) {
            room.setStatus(Status.BUSY);
            jdbcTemplate.update(updateSQL, room.getNumber(), room.getStatus().toString(), room.getPrice(), room.getId());
        } else if (room.getStatus().equals(Status.BUSY)) {
            room.setStatus(Status.FREE);
            jdbcTemplate.update(updateSQL, room.getNumber(), room.getStatus().toString(), room.getPrice(), room.getId());
        }
        return room;
    }
}