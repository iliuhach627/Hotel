package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.RoomStatus;
import org.springframework.stereotype.Component;

@Component
public class RoomDaoImpl extends AbstractDao<Room> implements RoomDao {


    /*private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into rooms (id, number, roomstatus, roomprice) values (?, ?, ?, ?)";
    private static final String findAllSQL = "select * from rooms";
    private static final String findByIdSQL = "select * from rooms where id = ?";
    private static final String deleteSQL = "delete from rooms where id = ?";
    private static final String updateSQL = "update rooms set number = ?, roomstatus = ?, roomprice = ? where id = ?";
*/
    public RoomDaoImpl() {
        super(Room.class);
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

/*
    @Override
    public Room save(Room room) {
        if (Objects.isNull(room.getId())) {
            room.setId(UUID.randomUUID());
            room.setStatus(RoomStatus.FREE);
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
*/

    @Override
    public Room changeStatus(Room room) {
        switch (room.getStatus()) {
            case FREE: {
                room.setStatus(RoomStatus.REPAIRED);
                break;
            }

            case REPAIRED: {
                room.setStatus(RoomStatus.FREE);
                break;
            }
            default:
                break;
        }
        //update(room);
        return room;
    }

    @Override
    public Room autoChangeStatus(Room room) {
        switch (room.getStatus()) {
            case FREE: {
                room.setStatus(RoomStatus.BUSY);
                break;
            }

            case BUSY: {
                room.setStatus(RoomStatus.FREE);
                break;
            }
            default:
                break;
        }
        //update(room);
        return room;
    }
}