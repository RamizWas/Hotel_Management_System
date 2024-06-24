package com.example.hotelmanage.booking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ("api/v1/booking"))
public class BookingController {

    BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return ResponseEntity.ok().body(bookingService.getAllBookings());
    }

    @PostMapping(path = "CreateBooking")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok().body(bookingService.createBooking(bookingDto));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") int id) {
    return ResponseEntity.ok().body(bookingService.getBookingById(id));
    }



}
