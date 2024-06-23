package com.example.hotelmanage.config;

import com.example.hotelmanage.guest.Guest;
import com.example.hotelmanage.guest.GuestDto;
import com.example.hotelmanage.guest.GuestRepo;
import com.example.hotelmanage.guest.LogInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping(path = "api/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final GuestRepo guestRepo;
    private final PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController( AuthenticationManager authenticationManager,
                           GuestRepo guestRepo,
                           PasswordEncoder passwordEncoder,
                           JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.guestRepo = guestRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator=jwtGenerator;
    }


    @PostMapping(path = "login")
    ResponseEntity<AuthResponseDto> login(@RequestBody LogInDto logInDto){
        log.info("logging in");
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(logInDto.getEmail()
                ,logInDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtGenerator.generateToken(authentication);
        return  new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }


    @PostMapping("/resgister")
    public ResponseEntity<String> registerUser(@RequestBody GuestDto guestDto){
        if(guestRepo.existsGuestByEmail(guestDto.getEmail())){
            return ResponseEntity.badRequest().body("Email already exists");
        }
      Guest guest=  mapToEntity(guestDto);

        guest.setPassword(passwordEncoder.encode(guest.getPassword()));

        //save guest
        guestRepo.save(guest);
        return new ResponseEntity<>("user registered Succesfully", HttpStatus.CREATED);



    }


    private Guest mapToEntity (GuestDto guestDto){
        Guest guest=new Guest();
        guest.setFullName(guestDto.getFullName());
        guest.setPhone(guestDto.getPhone());
        guest.setRole(guestDto.getRole());
        guest.setEmail(guestDto.getEmail());
        guest.setPassword(guestDto.getPassword());
        return guest;
    }



}
