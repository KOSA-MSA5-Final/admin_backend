//package com.example.demo.domains.disease.customtest;
//
//import com.example.demo.domains.disease.entity.DiseaseNames;
//import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseNamesRepositoryCustom;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * author : 김진석
// * date : 2024-09-24
// * description : 병명 대분류 커스텀 repository 테스트
// * <p>
// *
// * DATE            AUTHOR             NOTE
// * —————————————————————————————
// * 2024-09-25        김진석          최초 생성
// */
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan(basePackages = {"com.example.demo.domains.disease.repository.querydsl.customs.impl"}) // 커스텀 리포지토리 구현체 경로 확인
//public class DiseaseNamesRepositoryTest {
//
//    @Autowired
//    private DiseaseNamesRepositoryCustom diseaseNamesRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    public void setUp() {
//        // 대분류 병명 생성 - 순환계통(심장)
//        DiseaseNames diseaseNames = new DiseaseNames();
//        diseaseNames.setName("순환계통(심장)");
//        entityManager.persistAndFlush(diseaseNames);  // flush()를 사용하여 DB에 즉시 반영
//    }
//
//    @Test
//    @Transactional
//    public void testFindCustomDiseaseNames_ByPartialCondition() {
//        // "순환"으로 대분류 병명을 검색
//        List<DiseaseNames> result = diseaseNamesRepository.findCustomDiseaseNames("순환");
//
//        // 결과 확인
//        assertFalse(result.isEmpty());
//        assertEquals("순환계통(심장)", result.get(0).getName());
//    }
//}
