package com.senla.hotel.api.repository;

import com.senla.hotel.model.Order;

import java.util.UUID;

public interface OrderDao extends BaseDao<Order>{
    void update(Order order);
}
