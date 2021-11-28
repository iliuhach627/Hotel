package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.GuestDao;
import com.senla.hotel.model.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestDaoImpl extends AbstractDao<Guest> implements GuestDao {

    /* private final JdbcTemplate jdbcTemplate;
     private static final String createSQL = "insert into guests (id, name, surname, tel, age, gender) values (?, ?, ?, ?, ?, ?)";
     private static final String findAllSQL = "select * from guests";
     private static final String findByIdSQL = "select * from guests where id = ?";
     private static final String deleteSQL = "delete from guests where id = ?";
     private static final String updateSQL = "update guests set name = ?, surname = ?, tel = ?, age = ?, gender = ? where id = ?";
 */
    public GuestDaoImpl() {
        super(Guest.class);
        // this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

/*    @Override
    public Guest save(Guest guest) {

        if (Objects.isNull(guest.getId())) {
            guest.setId(UUID.randomUUID());
            entityManager.persist(guest);
            return guest;
            jdbcTemplate.update(createSQL, guest.getId(), guest.getName(), guest.getSurname(), guest.getTel(), guest.getAge(), guest.getGender());
        }else {
            jdbcTemplate.update(updateSQL, guest.getName(), guest.getSurname(), guest.getTel(), guest.getAge(), guest.getGender(), guest.getId());
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
    public void delete(UUID id) { jdbcTemplate.update(deleteSQL, id); }
    */
}