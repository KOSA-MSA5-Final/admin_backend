package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.Efficacy;
import com.example.demo.domains.product.repository.EfficacyRepository;
import com.example.demo.domains.product.service.impls.EfficacyServiceImps;
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
public class EfficacyServiceTest {

    @Mock
    private EfficacyRepository efficacyRepository;

    @InjectMocks
    private EfficacyServiceImps efficacyService;

    private Efficacy efficacy1;
    private Efficacy efficacy2;

    @BeforeEach
    public void setUp() {
        efficacy1 = new Efficacy();
        efficacy1.setId(1);
        efficacy1.setDetails("Good for skin");

        efficacy2 = new Efficacy();
        efficacy2.setId(2);
        efficacy2.setDetails("Helps with digestion");
    }

    @Test
    public void testGetAllEfficacies() {
        when(efficacyRepository.findAll()).thenReturn(Arrays.asList(efficacy1, efficacy2));

        List<Efficacy> result = efficacyService.getAllEfficacy();

        assertEquals(2, result.size());
        assertEquals(efficacy1, result.get(0));
        assertEquals(efficacy2, result.get(1));
    }
}