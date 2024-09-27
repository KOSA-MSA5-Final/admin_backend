package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Efficacy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.EfficacyRepository;
import com.example.demo.domains.product.repository.querydsl.impls.EfficacyRepositoryImpl;
import com.example.demo.domains.product.service.interfaces.EfficacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 기능 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class EfficacyServiceImps implements EfficacyService {
    private final EfficacyRepository efficacyRepository;

    @Override
    public List<Efficacy> getAllEfficacy() {
        return efficacyRepository.findAll();
    }

    @Override
    public Efficacy saveEfficacy(String details, Product product) {
        Efficacy efficacy = new Efficacy();
        efficacy.setDetails(details);
        efficacy.setProduct(product);
        return efficacyRepository.save(efficacy);
    }

    @Override
    public void deleteEfficacy(long id) {
        efficacyRepository.deleteById(id);
    }
}
