package com.example.hotelmanage.guest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LogInDto {
    private String email;
    private String password;

}
