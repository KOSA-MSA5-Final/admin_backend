package com.example.demo.domains.product.repository.querydsl.impls;

import com.example.demo.domains.product.entity.RawMaterial;
import com.example.demo.domains.product.repository.RawMaterialRepository;
import com.example.demo.domains.product.repository.querydsl.customs.RawMaterialRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 원료 레포지토리 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@RequiredArgsConstructor
public class RawMaterialRepositoryImpl implements RawMaterialRepositoryCustom {

    private final EntityManager em;
}
