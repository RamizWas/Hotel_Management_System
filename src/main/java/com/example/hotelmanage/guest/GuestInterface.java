package com.example.hotelmanage.guest;

import java.util.List;

public interface GuestInterface {

    List<GuestDto> getAllGuests();
    GuestDto getGuestById(int id);
    GuestDto addGuest(Guest guest);
    GuestDto updateGuest(Guest guest);
    void deleteGuest(int id);
    GuestDto findByFullname(String fullName);

}
