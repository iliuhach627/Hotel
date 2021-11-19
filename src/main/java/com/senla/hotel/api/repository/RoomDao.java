package com.senla.hotel.api.repository;

import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;

import java.util.UUID;

public interface RoomDao extends BaseDao<Room>{
    Room changeStatus(Room room);
    Room autoChangeStatus(Room room);
}
