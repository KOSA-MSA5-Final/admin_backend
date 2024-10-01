package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalDetailService;
import com.example.demo.domains.profile_medical.repository.AnimalDetailRepository;
import com.example.demo.domains.profile_medical.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 소분류 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class AnimalDetailServiceImpl implements AnimalDetailService {
    private final AnimalDetailRepository animalDetailRepository;
    private final AnimalRepository animalRepository;

    @Override
    public List<AnimalDetail> findAllDetailsByAnimal(Animal animal) {
        return animalDetailRepository.findByAnimal(animal);
    }

    @Override
    public AnimalDetail save(String name, String animalName) {
        Animal animal = animalRepository.findAnimalByName(animalName);
        if (animal == null) {
            System.out.println("존재하지 않는 대분류 동물입니다: " + animalName);
            return null;
        }
        // 소분류 동물 이름과 대분류 동물로 중복 확인
        if (animalDetailRepository.existsByNameAndAnimal(name, animal)) {
            System.out.println("동물 소분류가 이미 존재합니다: " + name);
            return null; // 중복일 경우 null 반환 (또는 예외 발생)
        }
        AnimalDetail animalDetail = new AnimalDetail();
        animalDetail.setName(name);
        animalDetail.setAnimal(animal);
        return animalDetailRepository.save(animalDetail);
    }

    @Override
    public Boolean delete(AnimalDetail animalDetail) {
        try{
            animalDetailRepository.delete(animalDetail);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Map<AnimalDetail, Integer> countProfilesByAnimalDetail() {
        return animalDetailRepository.countProfilesByAnimalDetail();
    }

    @Override
    public List<AnimalDetail> getAnimalDetailsByAnimalName(String animalName) {
        return animalDetailRepository.findAnimalDetailByAnimalName(animalName);
    }
}
