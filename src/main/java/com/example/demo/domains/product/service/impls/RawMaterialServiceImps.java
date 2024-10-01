package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.RawMaterial;
import com.example.demo.domains.product.repository.RawMaterialRepository;
import com.example.demo.domains.product.service.interfaces.RawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 원료 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class RawMaterialServiceImps implements RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;

    @Override
    public RawMaterial createRawMaterial(Product product, Allergy allergy) {
        RawMaterial newRawMaterial = new RawMaterial();
        newRawMaterial.setProduct(product);
        newRawMaterial.setAllergy(allergy);
        return rawMaterialRepository.save(newRawMaterial);
    }

    @Override
    public RawMaterial getRawMaterialById(Long id) {
        Optional<RawMaterial> rawMaterial = rawMaterialRepository.findById(id);
        return rawMaterial.orElseThrow(() -> new RuntimeException("RawMaterial not found with id: " + id));
    }

    @Override
    public List<RawMaterial> getAllRawMaterials() {
        return rawMaterialRepository.findAll();
    }

    @Override
    public RawMaterial updateRawMaterial(Long id, Product product, Allergy allergy) {
        RawMaterial rawMaterial = getRawMaterialById(id);

        // Assuming you want to update some fields of RawMaterial
        rawMaterial.setProduct(product);
        rawMaterial.setAllergy(allergy);

        return rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public void deleteRawMaterial(Long id) {
        RawMaterial rawMaterial = getRawMaterialById(id);
        rawMaterialRepository.delete(rawMaterial);
    }
}
