package com.example.hotelmanage.room;

import com.example.hotelmanage.cleaningSchedule.CleaningSchedule;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "room", schema = "hotel_booking")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cleaningScheduleId")
    private CleaningSchedule cleaningSchedule;

    @Size(max = 10)
    @Column(name = "room_number", length = 10)
    private String roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "StatusId")
    private  Integer statusId;

}