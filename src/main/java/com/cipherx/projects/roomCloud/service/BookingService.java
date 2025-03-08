package com.cipherx.projects.roomCloud.service;

import com.cipherx.projects.roomCloud.dto.BookingDto;
import com.cipherx.projects.roomCloud.dto.BookingRequest;
import com.cipherx.projects.roomCloud.dto.GuestDto;
import com.cipherx.projects.roomCloud.dto.HotelReportDto;
import com.cipherx.projects.roomCloud.entity.enums.BookingStatus;

import java.time.LocalDate;
import java.util.List;


public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<Long> guestIdList);

    String initiatePayments(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    List<BookingDto> getAllBookingsByHotelId(Long hotelId);

    HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDto> getMyBookings();
}
