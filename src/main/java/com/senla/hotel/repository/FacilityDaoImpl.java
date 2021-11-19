package com.senla.hotel.repository;

import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.mapper.row.FacilityRowMapper;
import com.senla.hotel.mapper.row.GuestRowMapper;
import com.senla.hotel.model.Facility;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Component
public class FacilityDaoImpl implements FacilityDao{

    private final JdbcTemplate jdbcTemplate;
    private static final String createSQL = "insert into facility (facilityid, title, facilityprice) values (?, ?, ?)";
    private static final String findAllSQL = "select * from facility";
    private static final String findByIdSQL = "select * from facility where facilityid = ?";
    private static final String deleteSQL = "delete from facility where facilityid = ?";
    private static final String updateSQL = "update facility set title = ?, facilityprice = ? where facilityid = ?";

    public FacilityDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
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
    }
}
