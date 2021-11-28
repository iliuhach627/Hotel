package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.model.Facility;
import org.springframework.stereotype.Component;

@Component
public class FacilityDaoImpl extends AbstractDao<Facility> implements FacilityDao {

    /*private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into facilities (id, title, facilityprice) values (?, ?, ?)";
    private static final String findAllSQL = "select * from facilities";
    private static final String findByIdSQL = "select * from facilities where id = ?";
    private static final String deleteSQL = "delete from facilities where id = ?";
    private static final String updateSQL = "update facilities set title = ?, facilityprice = ? where id = ?";
*/
    public FacilityDaoImpl() {
        super(Facility.class);
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*@Override
    public Facility save(Facility facility) {
        if (Objects.isNull(facility.getId())) {
            facility.setId(UUID.randomUUID());
            jdbcTemplate.update(createSQL, facility.getId(), facility.getTitle(), facility.getPrice());
        }else {
            jdbcTemplate.update(updateSQL, facility.getTitle(), facility.getPrice(), facility.getId());
        }
        return facility;
    }

    @Override
    public Collection<Facility> findAll() {

        return jdbcTemplate.query(findAllSQL, new FacilityRowMapper());
    }

    @Override
    public Facility findById(UUID id) {

        return jdbcTemplate.queryForObject(findByIdSQL, new FacilityRowMapper(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update(deleteSQL, id);
    }*/
}
