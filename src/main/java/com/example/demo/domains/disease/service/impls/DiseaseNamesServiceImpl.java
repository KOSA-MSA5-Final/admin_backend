package com.example.demo.domains.disease.service.impls;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.repository.DiseaseNamesRepository;
import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 병명 대분류 service 구현체 (기본 CRUD, 커스텀)
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@Service
@RequiredArgsConstructor
public class DiseaseNamesServiceImpl implements DiseaseNamesService {

    private final DiseaseNamesRepository diseaseNamesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DiseaseNames> findAllDiseases() {
        return diseaseNamesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DiseaseNames findDiseaseByName(String diseaseName) {
        return diseaseNamesRepository.findByName(diseaseName);
    }

    @Override
    @Transactional
    public DiseaseNames saveDisease(DiseaseNames diseaseNames) {
        return diseaseNamesRepository.save(diseaseNames);
    }

    @Override
    @Transactional
    public Boolean deleteDiseaseById(Long id) {
        try {
            diseaseNamesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 커스텀 조회 메서드
    @Override
    @Transactional(readOnly = true)
    public List<DiseaseNames> findCustomDiseaseNames(String condition) {
        return diseaseNamesRepository.findCustomDiseaseNames(condition);
    }
}
