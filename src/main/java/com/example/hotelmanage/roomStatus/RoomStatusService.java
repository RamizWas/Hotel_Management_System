package com.example.hotelmanage.roomStatus;

import com.example.hotelmanage.exception.ResourceNotFound;
import com.example.hotelmanage.guest.GuestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService implements RoomStatusServiceInterface{

    RoomStatusRepo roomStatusRepo;

    public RoomStatusService(RoomStatusRepo roomStatusRepo) {
        this.roomStatusRepo = roomStatusRepo;
    }

    private final Logger log = LoggerFactory.getLogger(GuestController.class);

    @Override
    public RoomStatusDto getRoomStatus(int id) {
        return mapToDta(roomStatusRepo.findById(id).get());
    }

    @Override
    public boolean deleteRoomStatus(int id) {
        if (roomStatusRepo.existsById(id))
        {
            roomStatusRepo.deleteById(id);
           return true;
        }
        return false;
    }

    @Override
    public RoomStatusDto updateRoomStatus(RoomStatus roomStatus) {

        if (!roomStatusRepo.existsById(roomStatus.getId())){
            log.error("Room Status not found ");
            throw new ResourceNotFound("Room Status","ID", roomStatus.getId());

        }

        return mapToDta(roomStatusRepo.save(roomStatus));
    }

    @Override
    public RoomStatusDto createRoomStatus(RoomStatusDto roomStatusDto) {
        return mapToDta(roomStatusRepo.save(maptoEntity(roomStatusDto)));
    }


    RoomStatusDto mapToDta(RoomStatus RoomStatus){
        RoomStatusDto roomStatusDto=new RoomStatusDto();
        roomStatusDto.setStatusName(RoomStatus.getStatusName());
        roomStatusDto.setId(RoomStatus.getId());
        return roomStatusDto;
    }

    RoomStatus maptoEntity(RoomStatusDto roomStatusDto){
        RoomStatus roomStatus=new RoomStatus();
        roomStatus.setStatusName(roomStatusDto.getStatusName());
        roomStatus.setId(roomStatus.getId());
        return roomStatus;

    }
}
