package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.ProductImg;
import com.example.demo.domains.product.repository.ProductImgRepository;
import com.example.demo.domains.product.repository.ProductRepository;
import com.example.demo.domains.product.service.impls.ProductImgServiceImps;
import com.example.demo.domains.product.service.impls.ProductServiceImps;
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
public class ProductImgServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImps productService;

    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        product1 = new Product();
        product1.setId(1);
        product1.setName("Product 1");
        product1.setMaker("Maker 1");
        product1.setType("Type 1");
        product1.setPrice(100);

        product2 = new Product();
        product2.setId(2);
        product2.setName("Product 2");
        product2.setMaker("Maker 2");
        product2.setType("Type 2");
        product2.setPrice(200);
    }

    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals(product1, result.get(0));
        assertEquals(product2, result.get(1));
    }
}
