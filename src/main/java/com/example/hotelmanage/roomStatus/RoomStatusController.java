package com.example.hotelmanage.roomStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/RoomStatus")
public class RoomStatusController {

    RoomStatusService roomStatusService;

    RoomStatusController(RoomStatusService roomStatusService) {
        this.roomStatusService = roomStatusService;
    }



    @GetMapping(path = "getbyid/{id}")
    public ResponseEntity<RoomStatusDto> getbyid(@PathVariable int id) {
        return ResponseEntity.ok().body(roomStatusService.getRoomStatus(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RoomStatusDto> deleteById(@PathVariable int id) {
        boolean deleted = roomStatusService.deleteRoomStatus(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<RoomStatusDto> UpdateRoomStatus(@RequestBody RoomStatus roomStatusDto) {
        RoomStatusDto updatedRoomStatus = roomStatusService.updateRoomStatus(roomStatusDto);
        return ResponseEntity.ok().body(updatedRoomStatus);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<RoomStatusDto> createRoomStatus(@RequestBody RoomStatusDto roomStatusDto) {
        RoomStatusDto createdRoomStatus = roomStatusService.createRoomStatus(roomStatusDto);
        return ResponseEntity.ok().body(createdRoomStatus);
    }

}
