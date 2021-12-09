package com.hotel.dao.api;

import com.hotel.dao.model.Guest;
import com.hotel.dao.model.Order;

import java.time.LocalDate;
import java.util.Collection;

public interface OrderDao extends BaseDao<Order> {
    Collection<Guest> findAllGuestsByRoomAndDate(String number, LocalDate date);
}
