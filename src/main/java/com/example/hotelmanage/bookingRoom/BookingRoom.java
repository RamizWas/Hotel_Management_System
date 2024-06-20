package com.example.hotelmanage.bookingRoom;

import com.example.hotelmanage.booking.Booking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_room", schema = "hotel_booking")
public class BookingRoom {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId")
    private Booking booking;

}