package com.senla.hotel.api.mapper;

import com.senla.hotel.model.BaseEntity;

public interface BaseMapper<DTO, ENTITY extends BaseEntity> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);

}
