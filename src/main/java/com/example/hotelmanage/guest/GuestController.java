package com.example.hotelmanage.guest;

import com.example.hotelmanage.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(path = "api/guest")

public class GuestController {
    private final Logger log = LoggerFactory.getLogger(GuestController.class);

    private GuestService guestService;
    private GuestRepo guestRepo;

    public GuestController(GuestService guestService,GuestRepo guestRepo) {
        this.guestService = guestService;
        this.guestRepo=guestRepo;
    }

    @GetMapping
    public ResponseEntity<List<GuestDto>> getAllGuests(){
        return ResponseEntity.ok().body(guestService.getAllGuests());
    }

    @GetMapping(path = "/getbyfullname/{fullname}")
    public ResponseEntity<GuestDto> getGuestByName( @PathVariable String fullname){
        GuestDto guestDto=guestService.findByFullname(fullname);
        return ResponseEntity.ok().body(guestDto);
    }

    @GetMapping(path = "/getguestbyid/{id}")
    public ResponseEntity<GuestDto> getGuestById(@PathVariable int id){

        GuestDto guestDto=guestService.getGuestById(id);

        return ResponseEntity.ok().body(guestDto);

    }


    @PostMapping(path = "/addGuest")
    public ResponseEntity<GuestDto> addGuest(@RequestBody Guest guest){

            if(guest.getId() != null){
                log.error("cannot have an id {}",guest);
                throw new BadRequestException(GuestController.class.getSimpleName(), "Id");
            }
            return new ResponseEntity<>(guestService.addGuest(guest), HttpStatus.CREATED);

    }




}
