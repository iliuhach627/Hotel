package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.OrderDao;
import com.senla.hotel.model.*;
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
                builder.equal( orderRoot.get(Order_.dateSettlement), date));

        return entityManager.createQuery(query).getResultList();
    }
}
