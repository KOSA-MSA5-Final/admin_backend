package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.product.entity.Ingredient;
import com.example.demo.domains.product.entity.Product;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 영양성분 서비스 인터페이스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    Ingredient saveIngredient(String name, String percentage, Product product);
    void deleteIngredient(long id);
}
