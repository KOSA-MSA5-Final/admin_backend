package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.disease.dto.DiseaseSubProfileDTO;
import com.example.demo.domains.disease.entity.DiseaseSubProfile;
import com.example.demo.domains.disease.repository.DiseaseSubProfileRepository;
import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.product.dto.ProfileAllergyDTO;
import com.example.demo.domains.product.entity.ProfileAllergy;
import com.example.demo.domains.product.repository.ProfileAllergyRepository;
import com.example.demo.domains.profile_medical.dto.ProfileDTO;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.entity.Medical;
import com.example.demo.domains.profile_medical.repository.ProfileRepository;
import com.example.demo.domains.profile_medical.service.interfaces.ProfileService;
import com.example.demo.dtos.ProfileDataDTO;
import com.example.demo.domains.profile_medical.entity.Profile;
import com.example.demo.domains.profile_medical.repository.ProfileRepository;
import com.example.demo.domains.profile_medical.service.interfaces.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 프로필 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileAllergyRepository profileAllergyRepository;
    private final DiseaseSubProfileRepository diseaseSubProfileRepository;

    @Override
    public List<Profile> getProfilesByMember(Member member) {
        return profileRepository.findByMember(member);
    }

    @Override
    public List<Medical> getMedicalsByMember(Member member) {
        return profileRepository.findMedicalByMember(member);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile save(String name, Integer age, Member member, AnimalDetail animalDetail, String pictureUrl) {
        Profile profile = new Profile();
        profile.setName(name);
        profile.setAge(age);
        profile.setMember(member);
        profile.setAnimalDetail(animalDetail);
        profile.setPictureUrl(pictureUrl);
        return profileRepository.save(profile);
    }

    @Override
    public Boolean delete(Profile profile) {
        try{
            profileRepository.delete(profile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Profile getCurrentProfileByMember(Member member) {
        List<Profile> profiles = profileRepository.findByMember(member);
        Profile profile = null;
        for (Profile p : profiles) {
            if(p.getIsCurrent().equals("T")){
                profile = p;
                break; // T인 프로필을 찾으면 더 이상 반복할 필요가 없으므로 종료 //나선주 추가
            }
        }
        return profile;
    }

    @Override
    public Profile changeProfile(Profile before, Long afterId) {
        before.setIsCurrent("F");
        Profile after = profileRepository.findById(afterId).get();
        after.setIsCurrent("T");
        profileRepository.save(before);

        return profileRepository.save(after);
    }

    @Override
    public Profile saveSpecificProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    // Profile 엔티티를 ProfileDTO로 변환하는 메서드
    public ProfileDTO convertToDTO(Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setId(profile.getId());
        dto.setName(profile.getName());
        dto.setGender(profile.getGender());
        dto.setAge(profile.getAge());
        dto.setBirthday(profile.getBirthday());
        dto.setIsNeutered(profile.getIsneutered());
        dto.setWillNeutered(profile.getWillneutered());
        dto.setPictureUrl(profile.getPictureUrl());
        dto.setIsCurrent(profile.getIsCurrent());

        // AnimalDetail의 이름을 설정
        if (profile.getAnimalDetail() != null) {
            dto.setAnimalType(profile.getAnimalDetail().getName());
            // Animal의 이름을 설정
            if (profile.getAnimalDetail().getAnimal() != null) {
                dto.setAnimalName(profile.getAnimalDetail().getAnimal().getName());
            } else {
                dto.setAnimalName("Unknown"); // Animal이 없는 경우 기본값 설정
            }
        } else {
            dto.setAnimalType("Unknown");
            dto.setAnimalName("Unknown");
        }

        // ProfileAllergy를 ProfileAllergyDTO로 변환하여 DTO에 추가
        List<ProfileAllergy> profileAllergies = profileAllergyRepository.findByProfile(profile);
        List<ProfileAllergyDTO> allergyDTOs = profileAllergies.stream()
                .map(allergy -> {
                    ProfileAllergyDTO allergyDTO = new ProfileAllergyDTO();
                    allergyDTO.setAllergyId(allergy.getAllergy().getId());
                    allergyDTO.setAllergyName(allergy.getAllergy().getName());
                    allergyDTO.setAllergyType(allergy.getAllergy().getType());
                    return allergyDTO;
                }).collect(Collectors.toList());
        dto.setAllergies(allergyDTOs);

        // DiseaseSubProfileRepository를 사용하여 질병 정보를 가져옴
        List<DiseaseSubProfile> diseaseSubProfiles = diseaseSubProfileRepository.findByProfile(profile);
        List<DiseaseSubProfileDTO> diseaseSubProfileDTOs = diseaseSubProfiles.stream()
                .map(diseaseSubProfile -> {
                    DiseaseSubProfileDTO diseaseSubProfileDTO = new DiseaseSubProfileDTO();
                    diseaseSubProfileDTO.setId(diseaseSubProfile.getId());
                    diseaseSubProfileDTO.setDiseaseName(diseaseSubProfile.getDiseaseSub().getDiseaseNames().getName()); // 대분류 이름
                    diseaseSubProfileDTO.setDiseaseSubCategory(diseaseSubProfile.getDiseaseSub().getName()); // 소분류 이름
                    diseaseSubProfileDTO.setDiagnosisDate(diseaseSubProfile.getDiagnosisDate());
                    diseaseSubProfileDTO.setProgressStatus(diseaseSubProfile.getProgressStatus());
                    return diseaseSubProfileDTO;
                })
                .collect(Collectors.toList());
        dto.setDiseases(diseaseSubProfileDTOs);

        return dto;
    }

    // 특정 회원의 모든 프로필을 ProfileDTO 리스트로 반환하는 메서드
    public List<ProfileDTO> getAllProfilesByMember(Member member) {
        List<Profile> profiles = profileRepository.findByMember(member);
        return profiles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
