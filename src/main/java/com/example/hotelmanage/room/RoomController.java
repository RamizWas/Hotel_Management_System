package com.example.hotelmanage.room;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(path = "/api/room/v1")
public class RoomController {

    RoomService roomService;

    RoomController(RoomService roomService){
        this.roomService=roomService;
    }



}
