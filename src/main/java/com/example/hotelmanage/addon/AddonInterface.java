package com.example.hotelmanage.addon;

public interface AddonInterface {
     AddonDto createAddon(AddonDto addon);

    // Read operation
    AddonDto getAddonById(int id);

    // Update operation
    void updateAddon(AddonDto addon);

    // Delete operation
    void deleteAddon(int id);
}
