package com.example.hotelmanage.config;

import com.example.hotelmanage.guest.Guest;
import com.example.hotelmanage.guest.GuestRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomGuestDetailsService implements UserDetailsService {
    @Autowired
  private GuestRepo guestRepo;
    private final Logger log = LoggerFactory.getLogger(CustomGuestDetailsService.class);


    CustomGuestDetailsService(GuestRepo guestRepo) {
      this.guestRepo = guestRepo;
  }

    public CustomGuestDetailsService() {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Guest guest=guestRepo.getGuestByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Guest not found"));
        log.info("loading by email");

        return new User(guest.getEmail(), guest.getPassword(), mapRoleToAuthority(guest.getRole()));


    }

    private Collection<GrantedAuthority> mapRoleToAuthority(String roles) {
        log.info("mapping to role {}", roles);

      return Collections.singletonList(new SimpleGrantedAuthority(roles));

    }
}
