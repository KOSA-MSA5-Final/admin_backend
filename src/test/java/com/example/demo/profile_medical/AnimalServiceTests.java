//package com.example.demo.profile_medical;
//
//import com.example.demo.domains.profile_medical.entity.Animal;
//import com.example.demo.domains.profile_medical.entity.AnimalDetail;
//import com.example.demo.domains.profile_medical.service.interfaces.AnimalDetailService;
//import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class AnimalServiceTests {
//    @Autowired
//    private AnimalService animalService;
//    @Autowired
//    private AnimalDetailService animalDetailService;
//
//
//    @Test
//    @Transactional
//    public void test_findAll() {
//        animalService.save("강아지");
//        animalService.save("고양이");
//        List<Animal> animals = animalService.getAllAnimals();
//        assertEquals(animals.size(), 2);
//    }
//
//    @Test
//    @Transactional
//    public void test_save_findAnimalByName_false(){
//        animalService.save("강아지");
//        animalService.save("고양이");
//        Animal result = animalService.save("강아지");
//        assertEquals(null, result);
//    }
//
//    @Test
//    @Transactional
//    public void test_findAnimalDetailsByAnimal(){
//        Animal animal = animalService.save("강아지");
//        animalDetailService.save("포메라니안", "강아지");
//        List<AnimalDetail> animalDetails = animalDetailService.findAllDetailsByAnimal(animal);
//        List<AnimalDetail> animalDeails1 = animalDetailService.getAnimalDetailsByAnimalName("강아지");
//
//        assertEquals(animalDetails, animalDeails1);
//        assertEquals(animalDeails1.size(), 1);
//    }
//}
