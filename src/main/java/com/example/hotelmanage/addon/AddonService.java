package com.example.hotelmanage.addon;

import com.example.hotelmanage.exception.BadRequestException;
import com.example.hotelmanage.exception.ResourceNotFound;
import com.example.hotelmanage.guest.GuestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddonService implements AddonInterface{
    AddonRepo addonRepo;
    private final Logger log = LoggerFactory.getLogger(GuestController.class);


    AddonService(AddonRepo addonRepo){
        this.addonRepo=addonRepo;
    }


    @Override
    public AddonDto createAddon(AddonDto addon) {
      return   mapToDto(addonRepo.save(mapToEntity(addon)));

    }

    @Override
    public AddonDto getAddonById(int id) {
        return mapToDto(addonRepo.findById(id).get());
    }

    @Override
    public AddonDto updateAddon(Addon addon) {

    if(!addonRepo.existsById(addon.getId())){
      log.error("addon not found, could not be updated");
      throw new ResourceNotFound("Addon","ID",addon.getId());

    }
    return mapToDto(addonRepo.save(addon));


    }

    @Override
    public boolean deleteAddon(int id) {

        if(addonRepo.existsById(id)){
            addonRepo.deleteById(id);
            return true;
        }
        return false;


    }

    AddonDto mapToDto(Addon addon){
        AddonDto addonDto=new AddonDto();
        addonDto.setAddonName(addon.getAddonName());
        addonDto.setPrice(addon.getPrice());
        return addonDto;
    }

    Addon mapToEntity(AddonDto addonDto){
        Addon addon=new Addon();
        addon.setAddonName(addonDto.getAddonName());
        addon.setPrice(addonDto.getPrice());
        return addon;
    }
}
