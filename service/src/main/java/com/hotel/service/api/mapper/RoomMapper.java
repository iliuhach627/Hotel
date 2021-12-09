package com.hotel.service.api.mapper;

import com.hotel.dao.model.Room;
import com.hotel.service.dto.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends BaseMapper<RoomDto, Room> {
}
