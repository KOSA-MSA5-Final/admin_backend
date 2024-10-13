package com.example.demo.controllers;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.service.impls.AllergyServiceImps;
import com.example.demo.domains.product.service.interfaces.AllergyService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.AnimalDetail;
import com.example.demo.domains.profile_medical.entity.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/allergy")
@RequiredArgsConstructor
public class AllergyController {

    private final AllergyServiceImps allergyService;

    // 동물 추가 폼 페이지
    @GetMapping("/add")
    public String showAddAllergyForm(Model model) {
        return "allergy/allergy-form";
    }

    // 알러지 추가 처리 메서드
    @PostMapping("/add/allergy")
    public String addAllergy(@RequestParam("allergyName") String allergyName,
                             @RequestParam("allergyType") String allergyType,
                             Model model) {
        try {
            // 알레르지 추가 서비스 호출
            allergyService.saveAllergy(allergyName, allergyType);
            model.addAttribute("message", "알러지가 성공적으로 추가되었습니다.");
            model.addAttribute("alertType", "success");
        } catch (Exception e) {
            model.addAttribute("message", "알러지 추가에 실패했습니다: " + e.getMessage());
            model.addAttribute("alertType", "danger");
        }
        return "redirect:/admin/allergy/add"; // 성공 시 리다이렉트
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteHospital(@PathVariable Long id) {
        allergyService.deleteAllergy(id);
        return "redirect:/admin/allergy";
    }
}
