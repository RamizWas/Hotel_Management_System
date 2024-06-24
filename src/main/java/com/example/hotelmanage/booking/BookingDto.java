package com.example.hotelmanage.booking;

import com.example.hotelmanage.guest.Guest;
import com.example.hotelmanage.paymentStatus.Paymentstatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
public class BookingDto {

    private int paymentStatusId;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;
    private int guestId;

    private Integer numAdults;

    private Integer numChildren;

    private Integer bookingAmount;

    private Guest  guest;
    private Paymentstatus paymentStatus;
}
