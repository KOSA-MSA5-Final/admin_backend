package com.example.demo.controllers;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @GetMapping("/category/main")
    public String getMainDiseaseList(Model model) {
        List<DiseaseNames> mainDiseases = diseaseNamesService.findAllDiseases(); // 대분류 병명 리스트 가져오기
        model.addAttribute("diseases", mainDiseases);
        model.addAttribute("showDiseaseNames", false); // 대분류는 설명이 없으므로 false
        return "disease/disease-list"; // 대분류 리스트 페이지로 이동
    }

    @GetMapping("/category/sub")
    public String getSubDiseaseList(Model model) {
        List<DiseaseSub> subDiseases = diseaseSubService.findAllDiseaseSubs(); // 소분류 병명 리스트 가져오기
        model.addAttribute("diseases", subDiseases);
        model.addAttribute("showDiseaseNames", true); // 소분류는 설명이 있으므로 true
        return "disease/disease-list"; // 소분류 리스트 페이지로 이동
    }

    @PostMapping("/delete/{id}")
    public String deleteDisease(@PathVariable Long id,
                                @RequestParam("category") String category,
                                RedirectAttributes redirectAttributes) {
        System.out.println("888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888");
        try {
            // 카테고리에 따라 삭제 로직 분기
            if ("main".equals(category)) {
                // 대분류 삭제 로직
                diseaseNamesService.deleteDiseaseById(id);
                redirectAttributes.addFlashAttribute("message", "대분류 병명이 성공적으로 삭제되었습니다.");
            } else if ("sub".equals(category)) {
                // 소분류 삭제 로직
                diseaseSubService.deleteDiseaseSubById(id);
                redirectAttributes.addFlashAttribute("message", "소분류 병명이 성공적으로 삭제되었습니다.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "삭제 중 오류가 발생했습니다.");
        }

        // 카테고리에 따라 적절한 페이지로 리다이렉트
        return "redirect:/admin/disease/category/" + category;
    }
}
