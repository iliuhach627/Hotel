package com.senla.hotel.service;

import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.api.repository.RoomDao;
import com.senla.hotel.api.service.OrderService;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.dto.OrderDto;
import com.senla.hotel.mapper.GuestMapper;
import com.senla.hotel.mapper.OrderMapper;
import com.senla.hotel.model.Guest;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.Room;
import com.senla.hotel.model.enums.SortedKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final RoomDao roomDao;
    private final OrderDao orderDao;
    private final OrderMapper mapper;
    private final GuestMapper guestMapper;

    @Transactional
    @Override
    public OrderDto create(OrderDto dto) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ЗАКАЗА!!!");
        Order orderEntity = mapper.toEntity(dto);
        Room room = roomDao.findById(orderEntity.getRoom().getId());
        roomDao.autoChangeStatus(room);
        orderEntity.setRoom(room);

        return mapper.toDto(orderDao.save(orderEntity));
    }

    @Override
    public Collection<OrderDto> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ЗАКАЗА!!!");
        return orderDao.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");
        return mapper.toDto(orderDao.findById(id));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");
        Order orderEntity = orderDao.findById(id);
        roomDao.autoChangeStatus(orderEntity.getRoom());
        orderDao.delete(id);
    }

    @Transactional
    @Override
    public void update(OrderDto dto) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");
        Order entity = mapper.toEntity(dto);
        orderDao.update(entity);
    }

    @Override
    public Collection<OrderDto> sortedByKey(SortedKey key) {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО ОТСОРТИРОВАННОГО В СЕРВИСЕ ЗАКАЗА!!!");
                return orderDao.findAll()
                        .stream()
                        .sorted(getComparator(key))
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
    }

    @Override
    public Comparator<Order> getComparator(SortedKey key) {
        Comparator<Order> comparator = null;
        switch (key) {
            case DATE_FREE:
                comparator = Comparator.comparing(Order::getDateSettlement);
                break;
            case DATE_SET:
                comparator = Comparator.comparing(Order::getDateFree);
                break;
        }
        return comparator;
    }

    @Override
    public Collection<GuestDto> findAllGuestsByRoomAndDate(String number, LocalDate date) {
        return orderDao.findAllGuestsByRoomAndDate(number, date)
                .stream()
                .map(guestMapper::toDto)
                .collect(Collectors.toList());
    }
}
