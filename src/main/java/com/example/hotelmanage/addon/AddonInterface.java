package com.example.hotelmanage.addon;

public interface AddonInterface {
    void createAddon(AddonDto addon);

    // Read operation
    AddonDto getAddonById(int id);

    // Update operation
    void updateAddon(AddonDto addon);

    // Delete operation
    void deleteAddon(int id);
}
