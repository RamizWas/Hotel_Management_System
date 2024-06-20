package com.example.hotelmanage.cleaningSchedule;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cleaning_schedule", schema = "hotel_booking")
public class CleaningSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "scheduleDate")
    private LocalDate scheduleDate;

    @Lob
    @Column(name = "description")
    private String description;

}