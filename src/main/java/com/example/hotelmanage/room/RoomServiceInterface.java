package com.example.hotelmanage.room;

public interface RoomServiceInterface {
    RoomDto getRoomById(int id);
    RoomDto updateRoom(RoomDto roomDto);
    void deleteRoom(int id);
    RoomDto createRoom(RoomDto roomDto);


}
