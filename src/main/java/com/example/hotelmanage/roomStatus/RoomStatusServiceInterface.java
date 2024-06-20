package com.example.hotelmanage.roomStatus;

public interface RoomStatusServiceInterface {
    RoomStatusDto getRoomStatus(int id);
    void deleteRoomStatus(int id);
    RoomStatusDto updateRoomStatus(RoomStatusDto roomStatusDto);
    RoomStatusDto createRoomStatus(RoomStatusDto roomStatusDto);

}
