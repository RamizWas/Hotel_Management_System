package com.example.hotelmanage.bookingRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRoomRepo extends JpaRepository<BookingRoom,Integer> {
}
