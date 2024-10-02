package com.example.demo.controllers;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/disease")
@RequiredArgsConstructor
public class DiseaseController {

    private final DiseaseNamesService diseaseNamesService;
    private final DiseaseSubService diseaseSubService;

    @GetMapping("/add")
    public String showAddDiseaseForm(Model model) {
        model.addAttribute("diseaseNames", diseaseNamesService.findAllDiseases());
        return "disease/disease-form"; // disease 폴더 내 disease-form.html로 이동
    }

    @PostMapping("/add/disease")
    public String addDisease(@RequestParam String diseaseName, RedirectAttributes redirectAttributes) {
        DiseaseNames newDisease = new DiseaseNames();
        newDisease.setName(diseaseName);

        // 저장 시 중복 확인 로직이 적용된 Service 호출
        DiseaseNames savedDisease = diseaseNamesService.saveDisease(newDisease);
        if (savedDisease == null) {
            redirectAttributes.addFlashAttribute("message", "대분류 병명이 이미 존재합니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        } else {
            redirectAttributes.addFlashAttribute("message", "대분류 병명이 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }
        return "redirect:/admin/disease/add";
    }

    @PostMapping("/add/diseaseSub")
    public String addDiseaseSub(@RequestParam String subDiseaseName, @RequestParam String diseaseName, RedirectAttributes redirectAttributes) {
        DiseaseNames diseaseNames = diseaseNamesService.findDiseaseByName(diseaseName);
        if (diseaseNames == null) {
            redirectAttributes.addFlashAttribute("message", "대분류 병명이 존재하지 않습니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
            return "redirect:/admin/disease/add";
        }

        DiseaseSub newSubDisease = new DiseaseSub();
        newSubDisease.setName(subDiseaseName);
        newSubDisease.setDiseaseNames(diseaseNames);

        // 저장 시 중복 확인 로직이 적용된 Service 호출
        DiseaseSub savedDiseaseSub = diseaseSubService.saveDiseaseSub(newSubDisease);
        if (savedDiseaseSub == null) {
            redirectAttributes.addFlashAttribute("message", "소분류 병명이 이미 존재합니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        } else {
            redirectAttributes.addFlashAttribute("message", "소분류 병명이 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }
        return "redirect:/admin/disease/add";
    }
}
