package com.senla.hotel.service;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.mapper.OrderMapper;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final RoomDao roomDao;
    private final OrderDao orderDao;
    private final FacilityDao facilityDao;
    private final GuestDao guestDao;
    private final OrderMapper mapper;

    @Transactional
    @Override
    public OrderDto create(OrderDto dto) {
        Order orderEntity = mapper.toEntity(dto);
        Room roomEntity = roomDao.findById(orderEntity.getRoom().getId());
        roomDao.autoChangeStatus(roomEntity);

        orderEntity.setGuest(guestDao.findById(orderEntity.getGuest().getId()));
        orderEntity.setFacility(facilityDao.findById(orderEntity.getFacility().getId()));
        orderEntity.setRoom(roomEntity);

        return mapper.toDto(orderDao.save(orderEntity));
    }

    @Override
    public Collection<OrderDto> findAll() {
        return orderDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(UUID id) {

        return mapper.toDto(orderDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        Order orderEntity = orderDao.findById(id);
        Room roomEntity = roomDao.findById(orderEntity.getRoom().getId());
        roomDao.autoChangeStatus(roomEntity);
        orderDao.delete(id);
    }

    @Transactional
    @Override
    public void update(OrderDto dto) {
        Order entity = mapper.toEntity(dto);
        orderDao.update(entity);
    }
}
