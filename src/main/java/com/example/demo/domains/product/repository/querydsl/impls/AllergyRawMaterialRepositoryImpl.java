package com.example.demo.domains.product.repository.querydsl.impls;

import com.example.demo.domains.product.entity.AllergyRawMaterial;
import com.example.demo.domains.product.repository.AllergyRawMaterialRepository;
import com.example.demo.domains.product.repository.querydsl.customs.AllergyRawMaterialRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 알러지-원료 레포지토리 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@RequiredArgsConstructor
public class AllergyRawMaterialRepositoryImpl implements AllergyRawMaterialRepositoryCustom {

    private final EntityManager em;
}
