package com.example.hotelmanage.config;

import lombok.Data;

@Data
public class AuthResponseDto {
    private  String accessToken;
    private String tokenType="Beaerer ";

    public  AuthResponseDto(String accessToken){
        this.accessToken=accessToken;
    }

}
