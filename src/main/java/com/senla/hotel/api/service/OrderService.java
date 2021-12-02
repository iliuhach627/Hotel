package com.senla.hotel.api.service;

import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.enums.SortedKey;

import java.util.Collection;
import java.util.UUID;

public interface OrderService {
    OrderDto create(OrderDto entity);

    Collection<OrderDto> findAll();

    OrderDto findById(UUID id);

    void delete(UUID id);

    void update(OrderDto entity);

    Collection<OrderDto> sortedByKey(SortedKey key);
}
