package com.example.demo.domains.member.repository;

import com.example.demo.domains.member.entity.Member;

import com.example.demo.domains.member.repository.querydsl.customs.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : MemberRepository
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findByEmail(String email);
}
