package com.cipherx.projects.roomCloud.service;

import com.cipherx.projects.roomCloud.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createNewRoom(Long HotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long HotelId);

    RoomDto getRoomById(Long roomId);

    void deleteRoomById(Long roomId);

    RoomDto updateRoomById(Long hotelId, Long roomId, RoomDto roomDto);
}
