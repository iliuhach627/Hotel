package com.senla.hotel.api.service;

import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.enums.SortedKey;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;

public interface OrderService {
    OrderDto create(OrderDto entity);

    Collection<OrderDto> findAll();

    OrderDto findById(UUID id);

    void delete(UUID id);

    void update(OrderDto entity);

    Collection<OrderDto> sortedByKey(SortedKey key);

    Comparator<Order> getComparator(SortedKey key);

    Collection<GuestDto> findAllGuestsByRoomAndDate(String number, LocalDate date);
}
