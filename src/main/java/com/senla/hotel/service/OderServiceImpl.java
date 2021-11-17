package com.senla.hotel.service;

import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.model.Guest;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final OrderDao orderDao;

    @Override
    public OrderDto create(OrderDto dto) {
        Order entity = modelMapper.map(dto, Order.class);
        return modelMapper.map(orderDao.save(entity), OrderDto.class);
    }

    @Override
    public Collection<OrderDto> findAll() {
        Order guestEntity = modelMapper.map(orderDao.findById(id), Guest.class);
        return orderDao.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public OrderDto update(OrderDto dto) {
        return null;
    }
}
