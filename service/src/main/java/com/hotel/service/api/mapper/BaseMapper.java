package com.hotel.service.api.mapper;

import com.hotel.dao.model.BaseEntity;

public interface BaseMapper<DTO, ENTITY extends BaseEntity> {
    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);
}
