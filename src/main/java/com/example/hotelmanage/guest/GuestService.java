package com.example.hotelmanage.guest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService implements GuestInterface {

   GuestRepo guestRepo;

   GuestService(GuestRepo guestRepo){
        this.guestRepo=guestRepo;
   }


    @Override
    public List<GuestDto> getAllGuests() {
        List<Guest> guests= guestRepo.findAll();

        return guests.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public GuestDto getGuestById(int id) {
        Guest guest=guestRepo.findById(id).get();
        return mapToDto(guest);
    }

    @Override
    public GuestDto addGuest(Guest guest) {
            Guest guestid =guestRepo.save(guest);
            return mapToDto(guestid);

    }

    @Override
    public GuestDto updateGuest(Guest guest) {
        guestRepo.save(guest);

        return mapToDto(guest);
    }

    @Override
    public void deleteGuest(int id) {
       guestRepo.deleteById(id);

    }

    @Override
    public GuestDto findByFullname(String fullName) {
        return mapToDto(guestRepo.getGuestByFullNameContaining(fullName));
    }


    private GuestDto mapToDto(Guest guest){
       GuestDto guestDto=new GuestDto();
       guestDto.setId(guest.getId());
       guestDto.setEmail(guest.getEmail());
       guestDto.setPhone(guest.getPhone());
       guestDto.setFullName(guest.getFullName());
       return guestDto;

    }
}
