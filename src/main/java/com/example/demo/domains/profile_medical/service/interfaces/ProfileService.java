package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.profile_medical.dto.ProfileDTO;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.dtos.ProfileDataDTO;

import java.util.List;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 프로필 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 * 2024-10-04        나선주            saveSpecificProfile 메소드생성
 */
public interface ProfileService {
    List<Profile> getProfilesByMember(Member member);
    List<Medical> getMedicalsByMember(Member member);
    List<Profile> getAllProfiles();
    Profile save(String name, Integer age, Member member, AnimalDetail animalDetail, String pictureUrl);
    Boolean delete(Profile profile);
    Profile getCurrentProfileByMember(Member member);
    Profile changeProfile(Profile before, Long afterId);

    Profile saveSpecificProfile(Profile profile);

    // 추가된 메서드 정의
    ProfileDTO convertToDTO(Profile profile);
    List<ProfileDTO> getAllProfilesByMember(Member member);
}
