package com.hotel.dao.impl;

import com.hotel.dao.api.OrderDao;
import com.hotel.dao.model.Guest;
import com.hotel.dao.model.Order;
import com.hotel.dao.model.Order_;
import com.hotel.dao.model.Room_;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    public Collection<Guest> findAllGuestsByRoomAndDate(String number, LocalDate date) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Guest> query = builder.createQuery(Guest.class);
        Root<Order> orderRoot = query.from(Order.class);

        query.select(orderRoot.get(Order_.guest));
        query.where(builder.equal(orderRoot.get(Order_.room).get(Room_.number), number),
                builder.equal(orderRoot.get(Order_.dateSettlement), date));

        return entityManager.createQuery(query).getResultList();
    }
}
