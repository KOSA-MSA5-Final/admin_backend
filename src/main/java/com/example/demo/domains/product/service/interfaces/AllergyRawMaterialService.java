package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.AllergyRawMaterial;
import com.example.demo.domains.product.entity.RawMaterial;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지-원료 서비스 인터페이스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface AllergyRawMaterialService {
    List<AllergyRawMaterial> getAllAllergyRawMaterials();
    AllergyRawMaterial saveAllergyRawMaterial(Allergy allergy, RawMaterial rawMaterial);
    void deleteAllergyRawMaterial(long id);
}
