package com.hotel.service.api.mapper;

import com.hotel.dao.model.Facility;
import com.hotel.service.dto.FacilityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper extends BaseMapper<FacilityDto, Facility> {
}
