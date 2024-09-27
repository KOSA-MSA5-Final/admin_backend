package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.RawMaterialsProduct;
import com.example.demo.domains.product.repository.RawMaterialsProductRepository;
import com.example.demo.domains.product.service.impls.RawMaterialsProductServiceImps;
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
public class RawMaterialsProductServiceTest {

    @Mock
    private RawMaterialsProductRepository rawMaterialsProductRepository;

    @InjectMocks
    private RawMaterialsProductServiceImps rawMaterialsProductService;

    private RawMaterialsProduct rmp1;
    private RawMaterialsProduct rmp2;

    @BeforeEach
    public void setUp() {
        rmp1 = new RawMaterialsProduct();
        rmp1.setId(1);
        rmp1.set_primary(true);

        rmp2 = new RawMaterialsProduct();
        rmp2.setId(2);
        rmp2.set_primary(false);
    }

    @Test
    public void testGetAllRawMaterialsProducts() {
        when(rawMaterialsProductRepository.findAll()).thenReturn(Arrays.asList(rmp1, rmp2));

        List<RawMaterialsProduct> result = rawMaterialsProductService.getAllRawMaterialsProducts();

        assertEquals(2, result.size());
        assertEquals(rmp1, result.get(0));
        assertEquals(rmp2, result.get(1));
    }
}
