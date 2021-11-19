package com.senla.hotel.repository;

import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.mapper.row.OrderRowMapper;
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
    private  final OrderRowMapper orderRowMapper;
    private static final String innerPart = " inner join guest g on ord.guestid = g.guestid" +
            " inner join room r on ord.roomid = r.roomid" +
            " inner join facility f on ord.facilitiesid = f.facilityid";
    private static final String createSQL = "insert into \"order\" (orderid, dataset, datafree, guestid, roomid, facilitiesid) values (?, ?, ?, ?, ?, ?)";
    private static final String findAllSQL = "select * from \"order\" ord" +
            innerPart;
    private static final String findByIdSQL = "select * from \"order\" ord" +
            innerPart + " where ord.orderid = ?";
    private static final String deleteSQL = "delete from \"order\" where orderid = ?";
    private static final String updateSQL = "update \"order\" set dataset = ?, datafree = ? where orderid = ?";

    public OrderDaoImpl(DataSource dataSource, OrderRowMapper orderRowMapper) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.orderRowMapper = orderRowMapper;
    }

    @Override
    public Order save(Order order) {
            order.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL,
                    order.getId(),
                    order.getDateSettlement(),
                    order.getDateFree(),
                    order.getGuest().getId(),
                    order.getRoom().getId(),
                    order.getFacility().getId());
        return order;
    }

    @Override
    public Collection<Order> findAll() {
        return jdbcTemplate.query(findAllSQL, orderRowMapper);
    }

    @Override
    public Order findById(UUID id) {
        return jdbcTemplate.queryForObject(findByIdSQL, orderRowMapper, id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }

    @Override
    public void update(Order order) {
        jdbcTemplate.update(updateSQL,
                order.getDateSettlement(),
                order.getDateFree(),
                order.getId());
    }
}
