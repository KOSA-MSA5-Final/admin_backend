package com.example.demo.domains.disease.service.impls;

import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.repository.NewDiseaseRepository;
import com.example.demo.domains.disease.service.interfaces.NewDiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 service 구현체 (기본 CRUD, 커스텀)
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24        김진석          최초 생성
 */

@Service
@RequiredArgsConstructor
public class NewDiseaseServiceImpl implements NewDiseaseService {

    private final NewDiseaseRepository newDiseaseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<NewDisease> findAllNewDiseases() {
        return newDiseaseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewDisease> findNewDiseasesByDiseaseNameId(Long diseaseNameId) {
        return newDiseaseRepository.findAllByDiseaseNames_Id(diseaseNameId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewDisease> findAllByNewDiseaseName(String name) {
        return newDiseaseRepository.findAllByName(name);
    }

    @Override
    @Transactional
    public NewDisease saveNewDisease(NewDisease newDisease) {
        return newDiseaseRepository.save(newDisease);
    }

    @Override
    @Transactional
    public Boolean deleteNewDiseaseById(Long id) {
        try {
            newDiseaseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // 커스텀 조회 메서드
    @Override
    @Transactional(readOnly = true)
    public List<NewDisease> findCustomNewDiseases(String condition) {
        return newDiseaseRepository.findCustomNewDiseases(condition);
    }
}
