package com.example.demo.domains.profile_medical.repository.querydsl.impls;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.repository.querydsl.customs.AnimalRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : 최혜령
 * date : 2024-09-24
 * description : 동물 대분류 커스텀 레포지토리 구현 클래스
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         최혜령          최초 생성
 * 2024-09-25         최혜령           findAnimalByName 생성
 */
@RequiredArgsConstructor
public class AnimalRepositoryImpl implements AnimalRepositoryCustom {
    private final EntityManager em;

    @Override
    public Map<Animal, Integer> countProfilesByAnimal() {
        String jpql = "SELECT a, COUNT(p) " +
                "FROM Profile p " +
                "JOIN p.animalDetail ad " +
                "JOIN ad.animal a " +
                "GROUP BY a";

        List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();

        // 결과를 Map<Animal, Integer> 형태로 변환
        Map<Animal, Integer> profileCountsByAnimal = new HashMap<>();
        for (Object[] result : results) {
            Animal animal = (Animal) result[0];
            Long count = (Long) result[1];
            profileCountsByAnimal.put(animal, count.intValue());
        }
        return profileCountsByAnimal;
    }

//    @Override
//    public Map<Animal, Integer> countAnimalDetailsByAnimal(){
//        String jpql = "SELECT a, COUNT(ad) FROM "
//    }

    @Override
    public Boolean isExist_AnimalByName(String name) {
        String jpql = "SELECT a FROM Animal a WHERE a.name LIKE :name";

        TypedQuery<Animal> query = em.createQuery(jpql, Animal.class);
        query.setParameter("name", "%" + name + "%"); // 정확히 일치하는 파라미터 설정
        List<Animal> results = query.getResultList();
        return !results.isEmpty(); // 리스트가 비어있지 않으면 true
    }

    @Override
    public Animal findAnimalByName(String name) {
        String jpql = "SELECT a FROM Animal a WHERE a.name LIKE :name";

        TypedQuery<Animal> query = em.createQuery(jpql, Animal.class);
        query.setParameter("name", "%" + name + "%"); // 정확히 일치하는 파라미터 설정
        List<Animal> results = query.getResultList();
        return results.get(0);
    }


}
