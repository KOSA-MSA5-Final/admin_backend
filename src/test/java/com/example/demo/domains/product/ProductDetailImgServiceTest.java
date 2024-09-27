package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.ProductDetailImg;
import com.example.demo.domains.product.repository.ProductDetailImgRepository;
import com.example.demo.domains.product.service.impls.ProductDetailImgServiceImps;
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
public class ProductDetailImgServiceTest {

    @Mock
    private ProductDetailImgRepository productDetailImgRepository;

    @InjectMocks
    private ProductDetailImgServiceImps productDetailImgService;

    private ProductDetailImg img1;
    private ProductDetailImg img2;

    @BeforeEach
    public void setUp() {
        img1 = new ProductDetailImg();
        img1.setId(1);
        img1.setImageUrl("http://image1.url");

        img2 = new ProductDetailImg();
        img2.setId(2);
        img2.setImageUrl("http://image2.url");
    }

    @Test
    public void testGetAllProductDetailImages() {
        when(productDetailImgRepository.findAll()).thenReturn(Arrays.asList(img1, img2));

        List<ProductDetailImg> result = productDetailImgService.getAllProductDetailImgs();

        assertEquals(2, result.size());
        assertEquals(img1, result.get(0));
        assertEquals(img2, result.get(1));
    }
}
