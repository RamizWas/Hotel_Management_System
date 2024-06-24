package com.example.hotelmanage.bookingRoom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "api/bookingroom")
public class BookingRoomController {
    BookingRoomService bookingRoomService;
    public BookingRoomController(BookingRoomService bookingRoomService) {
        this.bookingRoomService = bookingRoomService;
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<BookingRoomDto> getBookingRoom(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok().body(bookingRoomService.getBookingRoomById(id));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteBookingRoom(@PathVariable int id) {
        bookingRoomService.deleteBookingRoom(id);
        return ResponseEntity.ok().body("Booking room deleted");
    }
}
