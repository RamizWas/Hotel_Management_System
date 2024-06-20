package com.example.hotelmanage.guest;

import lombok.Data;

@Data
public class GuestDto {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
}
