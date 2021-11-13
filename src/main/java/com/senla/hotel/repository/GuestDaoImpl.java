package com.senla.hotel.repository;

import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.mapper.row.GuestRowMapper;
import com.senla.hotel.model.Guest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
public class GuestDaoImpl implements GuestDao {

    private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into guest (id, name, surname, tel, age, gender) values (?, ?, ?, ?, ?, ?)";
    private static final String findAllSQL = "select * from guest";
    private static final String findByIdSQL = "select * from guest where id = ?";
    private static final String deleteSQL = "delete from guest where id = ?";
    private static final String updateSQL = "update guest set name = ?, surname = ?, tel = ?, age = ?, gender = ? where id = ?";

    public GuestDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Guest save(Guest guest) {
        if (Objects.isNull(guest.getId())) {
            guest.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL, guest.getId(), guest.getName(), guest.getSurName(), guest.getTel(), guest.getAge(), guest.getGender());
        }else {
            jdbcTemplate.update(updateSQL, guest.getName(), guest.getSurName(), guest.getTel(), guest.getAge(), guest.getGender(), guest.getId());
        }
        return guest;
    }

    @Override
    public Collection<Guest> findAll() {
        return jdbcTemplate.query(findAllSQL, new GuestRowMapper());
    }

    @Override
    public Guest findById(UUID id) {

        return jdbcTemplate.queryForObject(findByIdSQL, new GuestRowMapper(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }
}
