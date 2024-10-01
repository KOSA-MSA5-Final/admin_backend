package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.ProfileAllergy;
import com.example.demo.domains.profile_medical.entity.Profile;

import java.util.List;

public interface ProfileAllergyService {

    // Create a new ProfileAllergy
    ProfileAllergy createProfileAllergy(Allergy allergy, Profile profile);

    // Get ProfileAllergy by ID
    ProfileAllergy getProfileAllergyById(Long id);

    // Get all ProfileAllergies
    List<ProfileAllergy> getAllProfileAllergies();

    // Update ProfileAllergy
    ProfileAllergy updateProfileAllergy(Long id, Allergy allergy, Profile profile);

    // Delete ProfileAllergy by ID
    void deleteProfileAllergy(Long id);
}
