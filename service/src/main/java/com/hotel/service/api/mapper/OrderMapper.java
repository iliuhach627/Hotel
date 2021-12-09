package com.hotel.service.api.mapper;

import com.hotel.dao.model.Order;
import com.hotel.service.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<OrderDto, Order> {
}
