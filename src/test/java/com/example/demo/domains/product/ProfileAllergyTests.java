package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.ProfileAllergy;
import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.repository.AllergyRepository;
import com.example.demo.domains.product.repository.ProfileAllergyRepository;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.profile_medical.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProfileAllergyTests {

    @Autowired
    private ProfileAllergyRepository profileAllergyRepository;

    @Autowired
    private AllergyRepository allergyRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testCreateProfileAllergy() {
        Allergy allergy = new Allergy();
        allergy.setName("Peanut");

        Profile profile = new Profile();
        profile.setName("Jane Doe");

        ProfileAllergy profileAllergy = new ProfileAllergy();
        profileAllergy.setAllergy(allergy);
        profileAllergy.setProfile(profile);

        allergyRepository.save(allergy);
        profileRepository.save(profile);

        ProfileAllergy savedProfileAllergy = profileAllergyRepository.save(profileAllergy);

        assertNotNull(savedProfileAllergy);
        assertEquals("Peanut", savedProfileAllergy.getAllergy().getName());
        assertEquals("Jane Doe", savedProfileAllergy.getProfile().getName());
    }

    @Test
    public void testDeleteProfileAllergy() {
        ProfileAllergy profileAllergy = new ProfileAllergy();
        profileAllergy.setId(1L); // Assuming an object with ID 1 exists
        profileAllergyRepository.delete(profileAllergy);
        assertFalse(profileAllergyRepository.existsById(1L));
    }
}