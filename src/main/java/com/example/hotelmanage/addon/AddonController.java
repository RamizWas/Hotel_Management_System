package com.example.hotelmanage.addon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/addon")
public class AddonController {
    AddonService addonService;

    AddonController(AddonService addonService){
        this.addonService=addonService;
    }

    @GetMapping(path = "getbyid/{id}")
    public ResponseEntity<AddonDto> getbyid(@PathVariable  int id){
        return ResponseEntity.ok().body(addonService.getAddonById(id));
    }

}
