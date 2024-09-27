package com.example.demo.domains.profile_medical.repository;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.ProfileRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 프로필 JPA 레포지토리
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface ProfileRepository extends JpaRepository<Profile, Long>, ProfileRepositoryCustom {
    List<Profile> findByMember(Member member);
    List<Medical> findMedicalByMember(Member member);
}
