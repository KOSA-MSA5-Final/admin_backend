package com.example.demo.domains.disease.service.impls;

import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.repository.DiseaseSubRepository;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 소분류 service 구현체 (기본 CRUD, 커스텀)
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@Service
@RequiredArgsConstructor
public class DiseaseSubServiceImpl implements DiseaseSubService {

    private final DiseaseSubRepository diseaseSubRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSub> findAllDiseaseSubs() {
        return diseaseSubRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSub> findSubDiseasesByDiseaseNameId(Long diseaseNameId) {
        return diseaseSubRepository.findAllByDiseaseNames_Id(diseaseNameId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSub> findAllByName(String name) {
        return diseaseSubRepository.findAllByName(name);
    }

    @Override
    @Transactional
    public DiseaseSub saveDiseaseSub(DiseaseSub diseaseSub) {
        return diseaseSubRepository.save(diseaseSub);
    }

    @Override
    @Transactional
    public Boolean deleteDiseaseSubById(Long id) {
        try {
            diseaseSubRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 커스텀 조회 메서드
    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSub> findCustomDiseaseSubs(String condition) {
        return diseaseSubRepository.findCustomDiseaseSubs(condition);
    }
}
