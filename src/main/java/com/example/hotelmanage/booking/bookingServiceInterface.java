package com.example.hotelmanage.booking;

import java.util.List;

public interface bookingServiceInterface {
    // Create a new booking
    BookingDto createBooking(BookingDto bookingDto);
    List<BookingDto> getAllBookings();

    // Read a booking by its ID
    BookingDto getBookingById(int bookingId);

    // Update an existing booking
    void updateBooking(Booking booking);

    // Delete a booking by its ID
    void deleteBooking(int bookingId);
}
