package com.senla.hotel.mapper;

import com.senla.hotel.api.mapper.BaseMapper;
import com.senla.hotel.dto.GuestDto;
import com.senla.hotel.model.Guest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper extends BaseMapper <GuestDto, Guest> {
}
