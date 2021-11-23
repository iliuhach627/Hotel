package com.senla.hotel.mapper;

import com.senla.hotel.api.mapper.BaseMapper;
import com.senla.hotel.dto.FacilityDto;
import com.senla.hotel.model.Facility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper extends BaseMapper<FacilityDto, Facility> {
}
