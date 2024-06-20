package com.example.hotelmanage.booking;

public interface bookingServiceInterface {
    // Create a new booking
    BookingDto createBooking(Booking booking);

    // Read a booking by its ID
    BookingDto getBookingById(int bookingId);

    // Update an existing booking
    void updateBooking(Booking booking);

    // Delete a booking by its ID
    BookingDto deleteBooking(int bookingId);
}
