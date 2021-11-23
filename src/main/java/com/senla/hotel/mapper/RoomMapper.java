package com.senla.hotel.mapper;

import com.senla.hotel.api.mapper.BaseMapper;
import com.senla.hotel.dto.RoomDto;
import com.senla.hotel.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends BaseMapper<RoomDto,Room> {
}
