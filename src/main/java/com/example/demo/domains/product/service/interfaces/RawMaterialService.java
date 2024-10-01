package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.RawMaterial;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 원료 서비스 인터페이스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface RawMaterialService {
    // Create a new RawMaterial
    RawMaterial createRawMaterial(Product product, Allergy allergy);

    // Get RawMaterial by ID
    RawMaterial getRawMaterialById(Long id);

    // Get all RawMaterials
    List<RawMaterial> getAllRawMaterials();

    // Update RawMaterial
    RawMaterial updateRawMaterial(Long id, Product product, Allergy allergy);

    // Delete RawMaterial by ID
    void deleteRawMaterial(Long id);
}
