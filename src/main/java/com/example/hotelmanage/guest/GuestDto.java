package com.example.hotelmanage.guest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class GuestDto {

    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String role;
}
