package com.senla.hotel.api.repository;

import com.senla.hotel.model.Room;

public interface RoomDao extends BaseDao<Room> {
    Room changeStatus(Room room);

    Room autoChangeStatus(Room room);
}
