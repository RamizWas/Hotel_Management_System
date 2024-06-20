package com.example.hotelmanage.addon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddonRepo extends JpaRepository<Addon,Integer> {
}
