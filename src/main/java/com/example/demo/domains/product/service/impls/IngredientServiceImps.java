package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Ingredient;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.IngredientRepository;
import com.example.demo.domains.product.service.interfaces.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 영양성분 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class IngredientServiceImps implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient saveIngredient(String name, String percentage, Product product) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setPercentage(percentage);
        ingredient.setProduct(product);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(long id) {
        ingredientRepository.deleteById(id);
    }
}
