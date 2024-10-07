package com.example.demo.domains.product.repository;

import com.example.demo.domains.product.entity.ProfileAllergy;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.product.repository.querydsl.customs.ProfileAllergyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-10-01
 * description : 프로필-알러지 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-10-01         윤다희          최초 생성
 */

public interface ProfileAllergyRepository extends JpaRepository<ProfileAllergy, Long> , ProfileAllergyRepositoryCustom {
    List<ProfileAllergy> findByProfile(Profile profile);
}
