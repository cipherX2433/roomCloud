package com.cipherx.projects.roomCloud.service;

import com.cipherx.projects.roomCloud.dto.HotelDto;
import com.cipherx.projects.roomCloud.dto.HotelInfoDto;
import com.cipherx.projects.roomCloud.dto.HotelInfoRequestDto;

import java.util.List;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    HotelInfoDto getHotelInfoById(Long hotelId, HotelInfoRequestDto hotelInfoRequestDto);

    List<HotelDto> getAllHotels();
}
