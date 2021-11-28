package com.senla.hotel.api.repository;

import com.senla.hotel.model.BaseEntity;

import java.util.Collection;
import java.util.UUID;

public interface BaseDao<ENTITY extends BaseEntity> {
    ENTITY save(ENTITY entity);
    Collection <ENTITY> findAll();
    ENTITY findById(UUID id);
    void delete(UUID id);
    void update(ENTITY entity);
}
