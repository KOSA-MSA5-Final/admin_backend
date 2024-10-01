package com.example.demo.domains.product.repository.querydsl.impls;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

/**
 * author : 윤다희
 * date : 2024-10-01
 * description : 프로필-알러지 레포지토리 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-10-01         윤다희          최초 생성
 */

@RequiredArgsConstructor
public class ProfileAllergyRepositoryImpl {
    private final EntityManager em;
}
