package com.example.demo.domains.product;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.repository.DiseaseNamesRepository;
import com.example.demo.domains.product.entity.DiseaseProduct;
import com.example.demo.domains.product.repository.DiseaseProductRepository;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.profile_medical.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DiseaseProductTests {

    @Autowired
    private DiseaseProductRepository diseaseProductRepository;

    @Autowired
    private DiseaseNamesRepository diseaseNamesRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testCreateDiseaseProduct() {
        DiseaseNames diseaseNames = new DiseaseNames();
        diseaseNames.setName("Heart Disease");

        Profile profile = new Profile();
        profile.setName("John Doe");

        DiseaseProduct diseaseProduct = new DiseaseProduct();
        diseaseProduct.setDiseaseNames(diseaseNames);
        diseaseProduct.setProfile(profile);

        diseaseNamesRepository.save(diseaseNames);
        profileRepository.save(profile);

        DiseaseProduct savedDiseaseProduct = diseaseProductRepository.save(diseaseProduct);

        assertNotNull(savedDiseaseProduct);
        assertEquals("Heart Disease", savedDiseaseProduct.getDiseaseNames().getName());
        assertEquals("John Doe", savedDiseaseProduct.getProfile().getName());
    }

    @Test
    public void testDeleteDiseaseProduct() {
        DiseaseProduct diseaseProduct = new DiseaseProduct();
        diseaseProduct.setId(1L); // Assuming an object with ID 1 exists
        diseaseProductRepository.delete(diseaseProduct);
        assertFalse(diseaseProductRepository.existsById(1L));
    }
}
