package com.example.demo.domains.profile_medical.service.impls;

import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 대분류 서비스 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 */
@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal save(String name) {
        if(animalRepository.isExist_AnimalByName(name) == false) {
            Animal animal = new Animal();
            animal.setName(name);
            return animalRepository.save(animal);
        }
        return null;
    }

    @Override
    public Boolean delete(Animal animal) {
        try{
            animalRepository.delete(animal);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Map<Animal, Integer> countProfilesByAnimal() {
        return animalRepository.countProfilesByAnimal();
    }
}
