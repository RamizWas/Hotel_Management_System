package com.example.hotelmanage.room;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public interface RoomServiceInterface {
    RoomDto getRoomById(int id);
    RoomDto updateRoom(RoomDto roomDto);
    void deleteRoom(int id);
    RoomDto createRoom(RoomDto roomDto);
    //get all rooms in pages

}
