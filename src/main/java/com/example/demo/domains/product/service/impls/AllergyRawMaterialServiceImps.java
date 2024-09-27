package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.AllergyRawMaterial;
import com.example.demo.domains.product.entity.RawMaterial;
import com.example.demo.domains.product.repository.AllergyRawMaterialRepository;
import com.example.demo.domains.product.service.interfaces.AllergyRawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지-원료 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class AllergyRawMaterialServiceImps implements AllergyRawMaterialService {
    private final AllergyRawMaterialRepository allergyRawMaterialRepository;

    @Override
    public List<AllergyRawMaterial> getAllAllergyRawMaterials() {
        return allergyRawMaterialRepository.findAll();
    }

    @Override
    public AllergyRawMaterial saveAllergyRawMaterial(Allergy allergy, RawMaterial rawMaterial) {
        AllergyRawMaterial allergyRawMaterial = new AllergyRawMaterial();
        allergyRawMaterial.setAllergy(allergy);
        allergyRawMaterial.setRawMaterial(rawMaterial);
        return allergyRawMaterialRepository.save(allergyRawMaterial);
    }

    @Override
    public void deleteAllergyRawMaterial(long id) {
        allergyRawMaterialRepository.deleteById(id);
    }
}
