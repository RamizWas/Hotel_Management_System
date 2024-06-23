package com.example.hotelmanage.addon;

public interface AddonInterface {
     AddonDto createAddon(AddonDto addon);

    // Read operation
    AddonDto getAddonById(int id);

    // Update operation
    AddonDto updateAddon(Addon addon);

    // Delete operation
    boolean deleteAddon(int id);
}
