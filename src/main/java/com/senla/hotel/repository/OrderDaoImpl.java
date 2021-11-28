package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.model.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    /*@PersistenceContext
    private EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;
    private static final String innerPart =
            " inner join guests g on ord.guestid = g.id" +
            " inner join rooms r on ord.roomid = r.id" +
            " inner join facilities f on ord.facilityid = f.id";
    private static final String createSQL =
            "insert into \"orders\" (id, dataset, datafree, guestid, roomid, facilityid)" +
            " values (?, ?, ?, ?, ?, ?)";
    private static final String findAllSQL = "select * from \"orders\" ord" +
            innerPart;
    private static final String findByIdSQL = "select * from \"orders\" ord" +
            innerPart + " where ord.id = ?";
    private static final String deleteSQL = "delete from \"orders\" where id = ?";
    private static final String updateSQL = "update \"orders\" set dataset = ?, datafree = ? where id = ?";*/

    public OrderDaoImpl() {
        super(Order.class);
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
        //this.orderRowMapper = orderRowMapper;
    }

/*
    @Override
    public Order save(Order order) {
        order.setId(UUID.randomUUID());
        jdbcTemplate.update(createSQL,
                order.getId(),
                order.getDateSettlement(),
                order.getDateFree(),
                order.getGuest().getId(),
                order.getRoom().getId());
                order.getFacilities().get();
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
*/
}
