package com.example.demo.domains.product.repository;

import com.example.demo.domains.product.entity.AllergyRawMaterial;
import com.example.demo.domains.product.repository.querydsl.customs.AllergyRawMaterialRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지-원료 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface AllergyRawMaterialRepository extends JpaRepository<AllergyRawMaterial, Long>, AllergyRawMaterialRepositoryCustom {

}
