package com.hotel.service.api.service;

import com.hotel.dao.model.Order;
import com.hotel.dao.model.enums.SortedKey;
import com.hotel.service.dto.GuestDto;
import com.hotel.service.dto.OrderDto;

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
