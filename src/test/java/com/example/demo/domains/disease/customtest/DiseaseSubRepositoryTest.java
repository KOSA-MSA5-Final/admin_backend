//package com.example.demo.domains.disease.customtest;
//
//import com.example.demo.domains.disease.entity.DiseaseNames;
//import com.example.demo.domains.disease.entity.DiseaseSub;
//import com.example.demo.domains.disease.repository.querydsl.customs.DiseaseSubRepositoryCustom;
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
// * description : 병명 소분류 커스텀 repository 테스트
// * <p>
// *
// * DATE            AUTHOR             NOTE
// * —————————————————————————————
// * 2024-09-25        김진석          최초 생성
// */
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan(basePackages = {"com.example.demo.domains.disease.repository.querydsl.customs.impl"})
//public class DiseaseSubRepositoryTest {
//
//    @Autowired
//    private DiseaseSubRepositoryCustom diseaseSubRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    private DiseaseNames diseaseNames;
//
//    @BeforeEach
//    public void setUp() {
//        // 대분류 병명 생성 - 순환계통(심장)
//        diseaseNames = new DiseaseNames();
//        diseaseNames.setName("순환계통(심장)");
//        entityManager.persist(diseaseNames);
//
//        // 소분류 병명 생성 - 비대성심근증
//        DiseaseSub diseaseSub = new DiseaseSub();
//        diseaseSub.setName("비대성심근증");
//        diseaseSub.setDiseaseNames(diseaseNames);  // 소분류 병명에 대분류 병명 연결
//        entityManager.persist(diseaseSub);
//    }
//

//    @Test
//    @Transactional
//    public void testFindCustomDiseaseSubs_ByPartialCondition() {
//        // "비대성"으로 소분류 병명을 검색
//        List<DiseaseSub> result = diseaseSubRepository.findCustomDiseaseSubs("비대성");
//
//        // 결과 확인
//        assertFalse(result.isEmpty());
//        assertEquals("비대성심근증", result.get(0).getName());
//        assertEquals("순환계통(심장)", result.get(0).getDiseaseNames().getName());  // 대분류 병명 확인
//    }

////    @Test
////    @Transactional
////    public void testFindCustomDiseaseSubs_ByPartialCondition() {
////        // "비대성"으로 소분류 병명을 검색
////        List<DiseaseSub> result = diseaseSubRepository.findCustomDiseaseSubs("비대성");
////
////        // 결과 확인
////        assertFalse(result.isEmpty());
////        assertEquals("비대성심근증", result.get(0).getName());
////        assertEquals("순환계통(심장)", result.get(0).getDiseaseNames().getName());  // 대분류 병명 확인
////    }

//}