package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.product.entity.DiseaseProduct;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.profile_medical.entity.Profile;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-10-01
 * description : 병명-상품 서비스 인터페이스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-10-01         윤다희          최초 생성
 */

public interface DiseaseProductService {
    // Create a new DiseaseProduct
    DiseaseProduct createDiseaseProduct(DiseaseNames diseaseNames, Product product);

    // Get DiseaseProduct by ID
    DiseaseProduct getDiseaseProductById(Long id);

    // Get all DiseaseProducts
    List<DiseaseProduct> getAllDiseaseProducts();

    // Update DiseaseProduct
    DiseaseProduct updateDiseaseProduct(Long id, DiseaseNames diseaseNames, Product product);

    // Delete DiseaseProduct by ID
    void deleteDiseaseProduct(Long id);
}
