package com.example.hotelmanage.bookingRoom;

import com.example.hotelmanage.booking.Booking;
import com.example.hotelmanage.room.Room;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BookingRoomDto {
    private Booking booking;

    private Room room;

}
