package com.example.hotelmanage.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
