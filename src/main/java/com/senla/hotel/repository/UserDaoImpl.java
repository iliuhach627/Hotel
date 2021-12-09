package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.UserDao;
import com.senla.hotel.model.User;
import com.senla.hotel.model.User_;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    public User loadUserByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.where(builder.equal(userRoot.get(User_.username), username));
        return entityManager.createQuery(query).getSingleResult();
    }
}
