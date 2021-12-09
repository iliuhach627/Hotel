package com.senla.hotel.repository;

import com.senla.hotel.api.repository.AbstractDao;
import com.senla.hotel.api.repository.FacilityDao;
import com.senla.hotel.model.Facility;
import org.springframework.stereotype.Component;

@Component
public class FacilityDaoImpl extends AbstractDao<Facility> implements FacilityDao {

    public FacilityDaoImpl() {
        super(Facility.class);
    }
}
