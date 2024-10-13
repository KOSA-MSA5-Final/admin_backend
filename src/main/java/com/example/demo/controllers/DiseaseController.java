package com.example.demo.controllers;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.entity.NewDisease;
import com.example.demo.domains.disease.service.impls.NewDiseaseServiceImpl;
import com.example.demo.domains.disease.service.interfaces.DiseaseNamesService;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/disease")
@RequiredArgsConstructor
public class DiseaseController {

    private final DiseaseNamesService diseaseNamesService;
    private final DiseaseSubService diseaseSubService;
    private final NewDiseaseServiceImpl newDiseaseService;

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

    @GetMapping("/sub")
    public String getSubDiseaseList(@RequestParam(required = false) Long type, Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        List<DiseaseSub> subDiseases;

        if (type != null && type != 0) {
            subDiseases = diseaseSubService.findSubDiseasesByDiseaseNameId(type);
        } else {
            subDiseases = diseaseSubService.findAllDiseaseSubs();
        }

        List<DiseaseNames> diseaseNames = diseaseNamesService.findAllDiseases();
        model.addAttribute("subcategories", subDiseases);
        model.addAttribute("diseases", diseaseNames);
        return "disease/disease-list"; // 소분류 리스트 페이지로 이동
    }

    @PostMapping("/delete/{id}")
    public String deleteDisease(@PathVariable Long id) {
        diseaseNamesService.deleteDiseaseById(id);

        // 카테고리에 따라 적절한 페이지로 리다이렉트
        return "redirect:/admin/disease";
    }

    // 소분류 병명 삭제
    @PostMapping("/admin/disease/sub/delete/{id}")
    public String deleteSubCategory(@PathVariable Long id) {
        diseaseSubService.deleteDiseaseSubById(id);
        return "redirect:/admin/disease/sub"; // 삭제 후 리스트 페이지로 리다이렉트
    }

    @GetMapping("/new")
    public String newDiseaseList(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<NewDisease> newDiseaseList = newDiseaseService.findAllNewDiseases();

        model.addAttribute("newDiseaseList", newDiseaseList);
        return "disease/disease-new"; // 소분류 리스트 페이지로 이동
    }

    // 소분류 병명 삭제
    @PostMapping("/admin/disease/new/delete/{id}")
    public String deleteNewCategory(@PathVariable Long id) {
        newDiseaseService.deleteNewDiseaseById(id);
        return "redirect:/admin/disease/new"; // 삭제 후 리스트 페이지로 리다이렉트
    }

}
