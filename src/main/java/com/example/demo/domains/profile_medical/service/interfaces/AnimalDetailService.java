package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;

import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 소분류 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface AnimalDetailService {
    List<AnimalDetail> findAllDetailsByAnimal(Animal animal);
    AnimalDetail save(String name, String animalName);
    Boolean delete(AnimalDetail animalDetail);
    Map<AnimalDetail, Integer> countProfilesByAnimalDetail();
    List<AnimalDetail> getAnimalDetailsByAnimalName(String animalName);
}
