package com.example.hotelmanage.booking;

import com.example.hotelmanage.guest.Guest;
import com.example.hotelmanage.guest.GuestRepo;
import com.example.hotelmanage.paymentStatus.PaymentStatusRepo;
import com.example.hotelmanage.paymentStatus.Paymentstatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService implements bookingServiceInterface{
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);
    private final GuestRepo guestRepo;
    BookingRepo bookingRepo;
    PaymentStatusRepo paymentStatusRepo;
    public BookingService(BookingRepo bookingRepo, GuestRepo guestRepo, PaymentStatusRepo paymentStatusRepo) {
        this.bookingRepo = bookingRepo;
        this.guestRepo = guestRepo;
        this.paymentStatusRepo = paymentStatusRepo;
    }



    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        return mapToDtoGP(bookingRepo.save(mapToBooking(bookingDto)));

    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> bookings=bookingRepo.findAll();

        return  bookings.stream().map(this::mapToDtoGP).collect(Collectors.toList());

    }

    @Override
    public BookingDto getBookingById(int bookingId) {

    return  mapToDtoGP(bookingRepo.findById(bookingId).get());


    }

    @Override
    public void updateBooking(Booking booking) {
            bookingRepo.save(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
       bookingRepo.deleteById(bookingId);
    }

    public BookingDto mapToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingAmount(booking.getBookingAmount());
        bookingDto.setCheckinDate(booking.getCheckinDate());
        bookingDto.setCheckoutDate(booking.getCheckoutDate());
        bookingDto.setNumAdults(booking.getNumAdults());
        bookingDto.setNumChildren(booking.getNumChildren());
        bookingDto.setPaymentStatusId(booking.getPaymentStatus().getId());
        bookingDto.setGuestId(booking.getGuest().getId());

        return bookingDto;
    }

    public BookingDto mapToDtoGP(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingAmount(booking.getBookingAmount());
        bookingDto.setCheckinDate(booking.getCheckinDate());
        bookingDto.setCheckoutDate(booking.getCheckoutDate());
        bookingDto.setNumAdults(booking.getNumAdults());
        bookingDto.setNumChildren(booking.getNumChildren());
        bookingDto.setGuest(booking.getGuest());
        bookingDto.setPaymentStatus(booking.getPaymentStatus());
        return bookingDto;

    }

    public Booking mapToBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setBookingAmount(bookingDto.getBookingAmount());
        booking.setCheckinDate(bookingDto.getCheckinDate());
        booking.setCheckoutDate(bookingDto.getCheckoutDate());
        booking.setNumAdults(bookingDto.getNumAdults());
        booking.setNumChildren(bookingDto.getNumChildren());
        booking.setGuest( guestRepo.getReferenceById(bookingDto.getGuestId()));
        booking.setPaymentStatus(paymentStatusRepo.getReferenceById(bookingDto.getPaymentStatusId()));
        return booking;
    }
}
