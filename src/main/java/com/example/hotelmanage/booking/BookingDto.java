package com.example.hotelmanage.booking;

import com.example.hotelmanage.paymentStatus.Paymentstatus;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;


@Data
public class BookingDto {

    private Paymentstatus paymentStatus;

    private LocalDate checkinDate;

    private LocalDate checkoutDate;

    private Integer numAdults;

    private Integer numChildren;

    private Integer bookingAmount;
}
