package com.senla.hotel.repository;

import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.mapper.row.OrderRowMapper;
import com.senla.hotel.mapper.row.RoomRowMapper;
import com.senla.hotel.model.Order;
import com.senla.hotel.model.enums.Status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
public class OrderDaoImpl implements OrderDao {

    private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into order (id, dataset, datafree, guestid, roomid, facilitiesid) values (?, ?, ?, ?, ?, ?)";
    private static final String findAllSQL = "select * from order";
    private static final String findByIdSQL = "select * from order where id = ?";
    private static final String deleteSQL = "delete from order where id = ?";
    private static final String updateSQL = "update order set dataset = ?, datafree = ? where id = ?";

    public OrderDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Order save(Order order) {
        if (Objects.isNull(order.getId())) {
            order.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL,
                    order.getId(),
                    order.getDateSettlement(),
                    order.getDateFree(),
                    order.getGuestId(),
                    order.getRoomId(),
                    order.getFacilityId());
        } else {
            jdbcTemplate.update(updateSQL,
                    order.getDateSettlement(),
                    order.getDateFree(),
                    order.getId());
        }
        return order;
    }

    @Override
    public Collection<Order> findAll() {
        return jdbcTemplate.query(findAllSQL, new OrderRowMapper());
    }

    @Override
    public Order findById(UUID id) {
        return jdbcTemplate.queryForObject(findByIdSQL, new OrderRowMapper(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }
}
