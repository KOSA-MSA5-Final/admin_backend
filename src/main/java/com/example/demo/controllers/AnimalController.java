package com.example.demo.controllers;

import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalDetailService;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;
    private final AnimalDetailService animalDetailService;

    // 동물 추가 폼 페이지
    @GetMapping("/add")
    public String showAddAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("animalDetail", new AnimalDetail());
        model.addAttribute("animals", animalService.getAllAnimals());
        return "/animal/animal-form"; // animal-form.html로 이동
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
}