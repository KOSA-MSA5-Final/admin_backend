package com.example.demo.domains.product.repository.querydsl.impls;

import com.example.demo.domains.product.entity.Efficacy;
import com.example.demo.domains.product.repository.EfficacyRepository;
import com.example.demo.domains.product.repository.querydsl.customs.EfficacyRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 기능 레포지토리 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@RequiredArgsConstructor
public class EfficacyRepositoryImpl implements EfficacyRepositoryCustom {
    private final EntityManager em;
}
