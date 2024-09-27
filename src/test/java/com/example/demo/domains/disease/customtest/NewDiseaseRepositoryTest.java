package com.example.demo.domains.disease.customtest;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.repository.querydsl.customs.NewDiseaseRepositoryCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author : 김진석
 * date : 2024-09-24
 * description : 새 병명 커스텀 repository 테스트
 * <p>
 *
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-25        김진석          최초 생성
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.example.demo.domains.disease.repository.querydsl.customs.impl"})
public class NewDiseaseRepositoryTest {

    @Autowired
    private NewDiseaseRepositoryCustom newDiseaseRepository;

    @Autowired
    private TestEntityManager entityManager;

    private DiseaseNames diseaseNames;

    @BeforeEach
    public void setUp() {
        // 대분류 병명 생성 - 순환계통(심장)
        diseaseNames = new DiseaseNames();
        diseaseNames.setName("순환계통(심장)");
        entityManager.persist(diseaseNames);

        // 새로운 병명 생성 - 저혈압
        NewDisease newDisease = new NewDisease();
        newDisease.setName("저혈압");
        newDisease.setDiseaseNames(diseaseNames);  // 새로운 병명에 대분류 병명 연결
        entityManager.persist(newDisease);
    }

    @Test
    @Transactional
    public void testFindCustomNewDiseases_ByPartialCondition() {
        // "혈압"으로 새로운 병명을 검색
        List<NewDisease> result = newDiseaseRepository.findCustomNewDiseases("혈압");

        // 결과 확인
        assertFalse(result.isEmpty());
        assertEquals("저혈압", result.get(0).getName());
        assertEquals("순환계통(심장)", result.get(0).getDiseaseNames().getName());  // 대분류 병명 확인
    }
}