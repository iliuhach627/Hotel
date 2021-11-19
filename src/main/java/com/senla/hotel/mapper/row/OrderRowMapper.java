package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRowMapper implements RowMapper<Order> {
    private final GuestRowMapper guestRowMapper;
    private final RoomRowMapper roomRowMapper;
    private final FacilityRowMapper facilityRowMapper;

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getObject("orderid", UUID.class));
        order.setDateSettlement(rs.getObject("dataset", LocalDate.class));
        order.setDateFree(rs.getObject("datafree", LocalDate.class));
        order.setGuest(guestRowMapper.mapRow(rs,rowNum));
        order.setRoom(roomRowMapper.mapRow(rs,rowNum));
        order.setFacility(facilityRowMapper.mapRow(rs,rowNum));
        return order;
    }
}
