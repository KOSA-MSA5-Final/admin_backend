package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.repository.AllergyRepository;
import com.example.demo.domains.product.service.impls.AllergyServiceImps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AllergyServiceTest {

    @Mock
    private AllergyRepository allergyRepository;

    @InjectMocks
    private AllergyServiceImps allergyService;

    private Allergy allergy1;
    private Allergy allergy2;

    @BeforeEach
    public void setUp() {
        allergy1 = new Allergy();
        allergy1.setId(1);
        allergy1.setName("Peanut");
        allergy1.setSymptoms("Hives");

        allergy2 = new Allergy();
        allergy2.setId(2);
        allergy2.setName("Shellfish");
        allergy2.setSymptoms("Swelling");
    }

    @Test
    public void testGetAllAllergies() {
        when(allergyRepository.findAll()).thenReturn(Arrays.asList(allergy1, allergy2));

        List<Allergy> result = allergyService.getAllAllergies();

        assertEquals(2, result.size());
        assertEquals(allergy1, result.get(0));
        assertEquals(allergy2, result.get(1));
    }
}
