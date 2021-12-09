package com.senla.hotel.api.repository;

import com.senla.hotel.model.Guest;
import com.senla.hotel.model.Order;

import java.time.LocalDate;
import java.util.Collection;

public interface OrderDao extends BaseDao<Order> {
    Collection<Guest> findAllGuestsByRoomAndDate(String number, LocalDate date);
}
