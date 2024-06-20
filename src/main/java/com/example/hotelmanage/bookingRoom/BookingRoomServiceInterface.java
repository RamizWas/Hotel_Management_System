package com.example.hotelmanage.bookingRoom;

import com.example.hotelmanage.booking.BookingDto;

public interface BookingRoomServiceInterface {
    BookingRoomDto getBookingRoomById(int id);
    void deleteBookingRoom(int id);
    BookingRoomDto createBookingRoom(BookingDto bookingDto);
    BookingRoomDto updateBookingRoom(BookingDto bookingDto);


}
