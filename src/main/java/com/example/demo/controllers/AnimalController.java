package com.example.demo.controllers;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.service.impls.AnimalDetailServiceImpl;
import com.example.demo.domains.profile_medical.service.impls.AnimalServiceImpl;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalDetailService;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private final AnimalDetailService animalDetailService;
    private final AnimalServiceImpl animalServiceImpl;
    private final AnimalDetailServiceImpl animalDetailServiceImpl;

    // 동물 추가 폼 페이지
    @GetMapping("/add")
    public String showAddAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("animalDetail", new AnimalDetail());
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animal/animal-form"; // animal-form.html로 이동
    }

    // 대분류 동물 추가
    @PostMapping("/add/animal")
    public String addAnimal(@RequestParam String animalName, RedirectAttributes redirectAttributes) {
        Animal savedAnimal = animalService.save(animalName);
        if (savedAnimal == null) {
            redirectAttributes.addFlashAttribute("message", "동물 대분류가 이미 존재합니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        } else {
            redirectAttributes.addFlashAttribute("message", "동물 대분류가 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }
        return "redirect:/admin/animal/add"; // 폼 페이지로 리다이렉트
    }

    // 소분류 동물 추가
    @PostMapping("/add/animalDetail")
    public String addAnimalDetail(@RequestParam String animalDetailName, @RequestParam String animalName, RedirectAttributes redirectAttributes) {
        AnimalDetail savedAnimalDetail = animalDetailService.save(animalDetailName, animalName);
        if (savedAnimalDetail == null) {
            redirectAttributes.addFlashAttribute("message", "동물 소분류가 이미 존재하거나 대분류 동물이 없습니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        } else {
            redirectAttributes.addFlashAttribute("message", "동물 소분류가 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }
        return "redirect:/admin/animal/add"; // 폼 페이지로 리다이렉트
    }

    @PostMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalServiceImpl.deleteById(id);
        // 카테고리에 따라 적절한 페이지로 리다이렉트
        return "redirect:/admin/animal";
    }

    @GetMapping("/sub")
    public String showSubAnimalForm(@RequestParam(required = false) String type, Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<AnimalDetail> animals;

        if (type != null && !type.isEmpty()) {
            // 대분류 동물 타입으로 소분류 동물 리스트를 조회
            Animal selectedCategory = animalServiceImpl.findAnimalByName(type);
            animals = animalDetailServiceImpl.findAllDetailsByAnimal(selectedCategory);
        } else {
            // 타입이 없는 경우 모든 소분류 동물 리스트를 조회
            animals = animalDetailServiceImpl.findAll();
        }

        // 모든 대분류 동물 카테고리를 가져와서 모델에 추가
        List<Animal> animalCategories = animalServiceImpl.getAllAnimals();

        model.addAttribute("subcategories", animals); // 소분류 동물 리스트
        model.addAttribute("animalCategories", animalCategories); // 대분류 동물 카테고리 리스트

        return "animal/animal-list"; // 동물 리스트 페이지로 이동
    }

    @PostMapping("/sub/delete/{id}")
    public String deleteAnimalDetail(@PathVariable Long id) {
        animalDetailServiceImpl.deleteById(id);
        return "redirect:/admin/animal";
    }
}