package com.example.hotelmanage.paymentStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paymentstatus", schema = "hotel_booking")
public class Paymentstatus {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "staus")
    private String staus;

}