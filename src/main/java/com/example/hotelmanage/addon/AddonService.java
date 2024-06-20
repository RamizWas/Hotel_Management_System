package com.example.hotelmanage.addon;

import org.springframework.stereotype.Service;

@Service
public class AddonService implements AddonInterface{
    AddonRepo addonRepo;

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
    public void updateAddon(AddonDto addon) {



    }

    @Override
    public void deleteAddon(int id) {

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
