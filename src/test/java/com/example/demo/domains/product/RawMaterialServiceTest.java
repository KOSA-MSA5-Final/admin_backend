package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.RawMaterial;
import com.example.demo.domains.product.repository.RawMaterialRepository;
import com.example.demo.domains.product.service.impls.RawMaterialServiceImps;
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
public class RawMaterialServiceTest {

    @Mock
    private RawMaterialRepository rawMaterialRepository;

    @InjectMocks
    private RawMaterialServiceImps rawMaterialService;

    private RawMaterial rawMaterial1;
    private RawMaterial rawMaterial2;

    @BeforeEach
    public void setUp() {
        rawMaterial1 = new RawMaterial();
        rawMaterial1.setId(1);

        rawMaterial2 = new RawMaterial();
        rawMaterial2.setId(2);
    }

    @Test
    public void testGetAllRawMaterials() {
        when(rawMaterialRepository.findAll()).thenReturn(Arrays.asList(rawMaterial1, rawMaterial2));

        List<RawMaterial> result = rawMaterialService.getAllRawMaterials();

        assertEquals(2, result.size());
        assertEquals(rawMaterial1, result.get(0));
        assertEquals(rawMaterial2, result.get(1));
    }
}
