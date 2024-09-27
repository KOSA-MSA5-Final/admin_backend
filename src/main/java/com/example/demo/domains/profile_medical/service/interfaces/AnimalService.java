package com.example.demo.domains.profile_medical.service.interfaces;

import com.example.demo.domains.profile_medical.entity.Animal;

import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 대분류 서비스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
public interface AnimalService {
    List<Animal> getAllAnimals();
    Animal save(String name);
    Boolean delete(Animal animal);
    Map<Animal, Integer> countProfilesByAnimal();
}
