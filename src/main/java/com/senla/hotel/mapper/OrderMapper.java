package com.senla.hotel.mapper;

import com.senla.hotel.api.mapper.BaseMapper;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<OrderDto, Order> {
}
