package com.example.demo.domains.member.repository.querydsl.impls;

import com.example.demo.domains.member.repository.querydsl.customs.MemberRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : MemberRepositoryImpl
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final EntityManager em;


}
