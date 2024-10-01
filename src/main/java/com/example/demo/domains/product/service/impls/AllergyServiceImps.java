package com.example.demo.domains.product.service.impls;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.repository.AllergyRepository;
import com.example.demo.domains.product.service.interfaces.AllergyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지 서비스 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@Service
@RequiredArgsConstructor
public class AllergyServiceImps implements AllergyService {
    private final AllergyRepository allergyRepository;

    @Override
    public List<Allergy> getAllAllergies() {
        return allergyRepository.findAll();
    }

    @Override
    public Allergy saveAllergy(String name, String type) {
        Allergy allergy = new Allergy();
        allergy.setName(name);
        allergy.setType(type);
        return allergyRepository.save(allergy);
    }

    @Override
    public void deleteAllergy(long id) {
        allergyRepository.deleteById(id);
    }

}
