package com.example.hotelmanage.addon;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddonDto {
    private String addonName;
    private Integer price;
}
