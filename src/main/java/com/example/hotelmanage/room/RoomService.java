package com.example.hotelmanage.room;

import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class RoomService implements RoomServiceInterface{
    RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public RoomDto getRoomById(int id) {
        return null;
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto) {
        return null;
    }

    @Override
    public void deleteRoom(int id) {

    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        return null;
    }






}
