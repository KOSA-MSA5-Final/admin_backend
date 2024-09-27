package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.AllergyRawMaterial;
import com.example.demo.domains.product.entity.RawMaterial;
import com.example.demo.domains.product.repository.AllergyRawMaterialRepository;
import com.example.demo.domains.product.service.impls.AllergyRawMaterialServiceImps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AllergyRawMaterialServiceTest {

    @Mock
    private AllergyRawMaterialRepository allergyRawMaterialRepository;

    @InjectMocks
    private AllergyRawMaterialServiceImps allergyRawMaterialService;

    private Allergy allergy;
    private RawMaterial rawMaterial1;
    private RawMaterial rawMaterial2;
    private AllergyRawMaterial allergyRawMaterial1;
    private AllergyRawMaterial allergyRawMaterial2;

    @BeforeEach
    public void setUp() {
        // 테스트 데이터 생성
        allergy = new Allergy();
        allergy.setId(1);
        allergy.setName("Peanut");
        allergy.setSymptoms("Hives");

        rawMaterial1 = new RawMaterial();
        rawMaterial1.setId(1);
        rawMaterial1.setName("Raw Material 1");
        rawMaterial1.setType("Type A");

        rawMaterial2 = new RawMaterial();
        rawMaterial2.setId(2);
        rawMaterial2.setName("Raw Material 2");
        rawMaterial2.setType("Type B");

        allergyRawMaterial1 = new AllergyRawMaterial();
        allergyRawMaterial1.setId(1);
        allergyRawMaterial1.setAllergy(allergy);
        allergyRawMaterial1.setRawMaterial(rawMaterial1);

        allergyRawMaterial2 = new AllergyRawMaterial();
        allergyRawMaterial2.setId(2);
        allergyRawMaterial2.setAllergy(allergy);
        allergyRawMaterial2.setRawMaterial(rawMaterial2);
    }

    @Test
    public void testGetAllAllergyRawMaterials() {
        // Mocking repository behavior
        when(allergyRawMaterialRepository.findAll()).thenReturn(Arrays.asList(allergyRawMaterial1, allergyRawMaterial2));

        // Execute service method
        List<AllergyRawMaterial> result = allergyRawMaterialService.getAllAllergyRawMaterials();

        // Validate the result
        assertEquals(2, result.size(), "Should return 2 AllergyRawMaterial objects");
        assertEquals(allergyRawMaterial1, result.get(0));
        assertEquals(allergyRawMaterial2, result.get(1));
    }
}