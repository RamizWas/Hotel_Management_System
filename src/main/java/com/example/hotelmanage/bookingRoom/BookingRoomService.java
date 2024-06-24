package com.example.hotelmanage.bookingRoom;

import com.example.hotelmanage.booking.BookingDto;
import com.example.hotelmanage.booking.BookingRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingRoomService implements BookingRoomServiceInterface{

    private BookingRepo bookingRepo;
   private  BookingRoomRepo bookingRoomRepo;
    public BookingRoomService(BookingRepo bookingRepo, BookingRoomRepo bookingRoomRepo) {
        this.bookingRepo = bookingRepo;
        this.bookingRoomRepo = bookingRoomRepo;
    }
    @Override
    public BookingRoomDto getBookingRoomById(int id) {


        return mapToDto(bookingRoomRepo.findById(id).get());
    }

    @Override
    public void deleteBookingRoom(int id) {
        bookingRoomRepo.deleteById(id);

    }

    @Override
    public BookingRoomDto createBookingRoom(BookingDto bookingDto) {
        return null;
    }

    @Override
    public BookingRoomDto updateBookingRoom(BookingDto bookingDto) {
        return null;
    }

    public BookingRoomDto mapToDto(BookingRoom booking){
        BookingRoomDto bookingDto = new BookingRoomDto();

        bookingDto.setBooking(bookingRepo.findById(booking.getBooking().getId()).get());
        bookingDto.setRoom(booking.getRoom());
        return bookingDto;
    }
}
