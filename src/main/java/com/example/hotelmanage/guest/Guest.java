package com.example.hotelmanage.guest;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Guest {
    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;

    private String email;
    private String phone;
    private String password;

}
