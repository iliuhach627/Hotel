package com.senla.hotel.repository;

import com.senla.hotel.api.repository.UserDao;
import com.senla.hotel.mapper.row.UserRowMapper;
import com.senla.hotel.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
public class UserDaoImpl implements UserDao {

    private static final String createSQL = "insert into \"user\" (userid, username, userstatus, password) values (?, ?, ?, ?)";
    private static final String findAllSQL = "select * from \"user\"";
    private static final String findByIdSQL = "select * from \"user\" where userid = ?";
    private static final String deleteSQL = "delete from \"user\" where userid = ?";
    private static final String updateSQL = "update \"user\" set username = ?, userstatus = ?, password = ? where userid = ?";
    private static final String loadUserByUserNameSQL = "select * from \"user\" where username = ?";
    private final JdbcTemplate jdbcTemplate;


    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL, user.getId(), user.getName(), user.getUserStatus().toString(), user.getPassword());
        } else {
            jdbcTemplate.update(updateSQL, user.getName(), user.getUserStatus().toString(), user.getPassword(), user.getId());
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
    }

    public User loadUserByUsername(String userName) {
        return jdbcTemplate.queryForObject(loadUserByUserNameSQL, new UserRowMapper(), userName);
    }
}
