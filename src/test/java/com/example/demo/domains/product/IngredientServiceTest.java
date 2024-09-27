package com.example.demo.domains.product;

import com.example.demo.domains.product.entity.Ingredient;
import com.example.demo.domains.product.repository.IngredientRepository;
import com.example.demo.domains.product.service.impls.IngredientServiceImps;
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
public class IngredientServiceTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImps ingredientService;

    private Ingredient ingredient1;
    private Ingredient ingredient2;

    @BeforeEach
    public void setUp() {
        ingredient1 = new Ingredient();
        ingredient1.setId(1);
        ingredient1.setName("Water");
        ingredient1.setPercentage("100%");

        ingredient2 = new Ingredient();
        ingredient2.setId(2);
        ingredient2.setName("Sugar");
        ingredient2.setPercentage("10%");
    }

    @Test
    public void testGetAllIngredients() {
        when(ingredientRepository.findAll()).thenReturn(Arrays.asList(ingredient1, ingredient2));

        List<Ingredient> result = ingredientService.getAllIngredients();

        assertEquals(2, result.size());
        assertEquals(ingredient1, result.get(0));
        assertEquals(ingredient2, result.get(1));
    }
}