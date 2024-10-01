package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.ProfileAllergy;
import com.example.demo.domains.product.repository.ProfileAllergyRepository;
import com.example.demo.domains.product.service.interfaces.ProfileAllergyService;
import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileAllergyServiceImps implements ProfileAllergyService {

    private final ProfileAllergyRepository profileAllergyRepository;

    @Override
    public ProfileAllergy createProfileAllergy(Allergy allergy, Profile profile) {
        ProfileAllergy profileAllergy = new ProfileAllergy();
        profileAllergy.setAllergy(allergy);
        profileAllergy.setProfile(profile);
        return profileAllergyRepository.save(profileAllergy);
    }

    @Override
    public ProfileAllergy getProfileAllergyById(Long id) {
        Optional<ProfileAllergy> profileAllergy = profileAllergyRepository.findById(id);
        return profileAllergy.orElseThrow(() -> new RuntimeException("ProfileAllergy not found with id: " + id));
    }

    @Override
    public List<ProfileAllergy> getAllProfileAllergies() {
        return profileAllergyRepository.findAll();
    }

    @Override
    public ProfileAllergy updateProfileAllergy(Long id, Allergy allergy, Profile profile) {
        ProfileAllergy profileAllergy = getProfileAllergyById(id);

        // Assuming you want to update some fields of ProfileAllergy
        profileAllergy.setAllergy(allergy);
        profileAllergy.setProfile(profile);

        return profileAllergyRepository.save(profileAllergy);
    }

    @Override
    public void deleteProfileAllergy(Long id) {
        ProfileAllergy profileAllergy = getProfileAllergyById(id);
        profileAllergyRepository.delete(profileAllergy);
    }
}
