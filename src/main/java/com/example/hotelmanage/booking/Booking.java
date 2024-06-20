package com.example.hotelmanage.booking;

import com.example.hotelmanage.paymentStatus.Paymentstatus;
import com.example.hotelmanage.guest.Guest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking", schema = "hotel_booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guestId")
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentStatusId")
    private Paymentstatus paymentStatus;

    @Column(name = "checkinDate")
    private LocalDate checkinDate;

    @Column(name = "checkoutDate")
    private LocalDate checkoutDate;

    @Column(name = "numAdults")
    private Integer numAdults;

    @Column(name = "numChildren")
    private Integer numChildren;

    @Column(name = "bookingAmount")
    private Integer bookingAmount;

}