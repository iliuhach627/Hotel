package com.senla.hotel.service;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final RoomDao roomDao;
    private final OrderDao orderDao;
    private final FacilityDao facilityDao;
    private final GuestDao guestDao;

    @Transactional
    @Override
    public OrderDto create(OrderDto dto) {
        Order orderEntity = modelMapper.map(dto, Order.class);
        orderEntity.setGuest(guestDao.findById(orderEntity.getGuest().getId()));
        orderEntity.setFacility(facilityDao.findById(orderEntity.getFacility().getId()));
        orderEntity.setRoom(roomDao.findById(orderEntity.getRoom().getId()));

        Room roomEntity = roomDao.findById(orderEntity.getRoom().getId());
        roomDao.autoChangeStatus(roomEntity);
        return modelMapper.map(orderDao.save(orderEntity), OrderDto.class);
    }

    @Override
    public Collection<OrderDto> findAll() {
        return orderDao.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(UUID id) {

        return modelMapper.map(orderDao.findById(id),OrderDto.class);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        Order orderEntity = modelMapper.map(orderDao.findById(id), Order.class);
        Room roomEntity = roomDao.findById(orderEntity.getRoom().getId());
        roomDao.autoChangeStatus(roomEntity);
        orderDao.delete(id);
    }

    @Transactional
    @Override
    public void update(OrderDto dto) {
        Order entity = modelMapper.map(dto, Order.class);
        orderDao.update(entity);
    }
}
