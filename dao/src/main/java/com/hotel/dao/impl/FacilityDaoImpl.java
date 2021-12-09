package com.hotel.dao.impl;

import com.hotel.dao.api.FacilityDao;
import com.hotel.dao.model.Facility;
import org.springframework.stereotype.Component;

@Component
public class FacilityDaoImpl extends AbstractDao<Facility> implements FacilityDao {

    public FacilityDaoImpl() {
        super(Facility.class);
    }
}
