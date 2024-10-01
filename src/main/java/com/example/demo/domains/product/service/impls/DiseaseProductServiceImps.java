package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.product.entity.DiseaseProduct;
import com.example.demo.domains.product.repository.DiseaseProductRepository;
import com.example.demo.domains.product.service.interfaces.DiseaseProductService;
import com.example.demo.domains.profile_medical.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * author : 윤다희
 * date : 2024-10-01
 * description : 병명-상품 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-10-01         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class DiseaseProductServiceImps implements DiseaseProductService {

    private final DiseaseProductRepository diseaseProductRepository;

    @Override
    public DiseaseProduct createDiseaseProduct(DiseaseNames diseaseNames, Profile profile) {
        DiseaseProduct diseaseProduct = new DiseaseProduct();
        diseaseProduct.setDiseaseNames(diseaseNames);
        diseaseProduct.setProfile(profile);
        return diseaseProductRepository.save(diseaseProduct);
    }

    @Override
    public DiseaseProduct getDiseaseProductById(Long id) {
        Optional<DiseaseProduct> diseaseProduct = diseaseProductRepository.findById(id);
        return diseaseProduct.orElseThrow(() -> new RuntimeException("DiseaseProduct not found with id: " + id));
    }

    @Override
    public List<DiseaseProduct> getAllDiseaseProducts() {
        return diseaseProductRepository.findAll();
    }

    @Override
    public DiseaseProduct updateDiseaseProduct(Long id, DiseaseNames diseaseNames, Profile profile) {
        DiseaseProduct diseaseProduct = getDiseaseProductById(id);

        // Assuming you want to update some fields of DiseaseProduct
        diseaseProduct.setDiseaseNames(diseaseNames);
        diseaseProduct.setProfile(profile);

        return diseaseProductRepository.save(diseaseProduct);
    }

    @Override
    public void deleteDiseaseProduct(Long id) {
        DiseaseProduct diseaseProduct = getDiseaseProductById(id);
        diseaseProductRepository.delete(diseaseProduct);
    }
}
