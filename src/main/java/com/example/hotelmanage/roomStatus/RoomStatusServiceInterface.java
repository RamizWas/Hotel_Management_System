package com.example.hotelmanage.roomStatus;

public interface RoomStatusServiceInterface {
    RoomStatusDto getRoomStatus(int id);
    boolean deleteRoomStatus(int id);
    RoomStatusDto updateRoomStatus(RoomStatus roomStatus);
    RoomStatusDto createRoomStatus(RoomStatusDto roomStatusDto);

}
