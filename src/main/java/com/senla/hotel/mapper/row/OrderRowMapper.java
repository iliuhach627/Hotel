package com.senla.hotel.mapper.row;

import com.senla.hotel.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getObject("id", UUID.class));
        order.setDateSettlement(rs.getObject("dataset", LocalDate.class));
        order.setDateFree(rs.getObject("datafree", LocalDate.class));
        order.setGuestId(rs.getObject("guestid", UUID.class));
        order.setRoomId(rs.getObject("roomid", UUID.class));
        order.setFacilityId(rs.getObject("facilitiesid", UUID.class));
        return order;
    }
}
