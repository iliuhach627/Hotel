package com.hotel.dao.impl;

import com.hotel.dao.api.RoomDao;
import com.hotel.dao.model.Room;
import com.hotel.dao.model.enums.RoomStatus;
import org.springframework.stereotype.Component;

@Component
public class RoomDaoImpl extends AbstractDao<Room> implements RoomDao {

    public RoomDaoImpl() {
        super(Room.class);
    }

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
        return room;
    }
}