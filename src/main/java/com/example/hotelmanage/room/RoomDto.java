package com.example.hotelmanage.room;

import com.example.hotelmanage.cleaningSchedule.CleaningSchedule;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoomDto {


    private CleaningSchedule cleaningSchedule;
    private String roomNumber;
    private Integer floor;
    private  Integer statusId;
}
