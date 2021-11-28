package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.UserDao;
import com.senla.hotel.model.User;
import com.senla.hotel.model.User_;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    /*private static final String createSQL = "insert into \"users\" (id, username, userstatus, password) values (?, ?, ?, ?)";
    private static final String findAllSQL = "select * from \"users\"";
    private static final String findByIdSQL = "select * from \"users\" where id = ?";
    private static final String deleteSQL = "delete from \"users\" where id = ?";
    private static final String updateSQL = "update \"users\" set username = ?, userstatus = ?, password = ? where id = ?";
    private static final String loadUserByUserNameSQL = "select * from \"users\" where username = ?";
    private final JdbcTemplate jdbcTemplate;*/


    public UserDaoImpl() {
        super(User.class);
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

 /*   @Override
    public User save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL, user.getId(), user.getUsername(), user.getStatus().toString(), user.getPassword());
        } else {
            jdbcTemplate.update(updateSQL, user.getUsername(), user.getStatus().toString(), user.getPassword(), user.getId());
        }
        return user;
    }

    @Override
    public Collection<User> findAll() {
        return jdbcTemplate.query(findAllSQL, new UserRowMapper());
    }

    @Override
    public User findById(UUID id) {
        return jdbcTemplate.queryForObject(findByIdSQL, new UserRowMapper(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }*/

    public User loadUserByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        query.select(userRoot);
        query.where(builder.equal(userRoot.get(User_.username), username));
        return entityManager.createQuery(query).getSingleResult();
    }


}
