package com.hotel.service.api.mapper;

import com.hotel.dao.model.Guest;
import com.hotel.service.dto.GuestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper extends BaseMapper<GuestDto, Guest> {
}
