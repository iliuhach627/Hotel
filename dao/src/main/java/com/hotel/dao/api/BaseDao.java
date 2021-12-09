package com.hotel.dao.api;

import com.hotel.dao.model.BaseEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface BaseDao<ENTITY extends BaseEntity> {
    ENTITY save(ENTITY entity);

    Collection<ENTITY> findAll();

    Optional<ENTITY> findById(UUID id);

    void delete(UUID id);

    void update(ENTITY entity);
}
