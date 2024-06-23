package com.example.hotelmanage.guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer> {

    Guest getGuestByFullNameContaining(String fullName);
    Optional<Guest> getGuestByEmail(String email);
    Boolean existsGuestByEmail(String email);



}
