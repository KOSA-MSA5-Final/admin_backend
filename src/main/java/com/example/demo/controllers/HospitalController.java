package com.example.demo.controllers;

import ch.qos.logback.core.model.Model;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.HospitalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalServiceImpl hospitalService;

    @GetMapping("/add")
    public String showAddHospital(Model model) {
        return "hospital/hospital-form";
    }

    @PostMapping("/add/hospital")
    public String addHospital(@RequestParam Long id, String hospitalName, String hospitalAddress, String doctorName, String phoneNumber, String isOurs, RedirectAttributes redirectAttributes) {
        if(Objects.equals(isOurs, "제휴병원")){
            isOurs = "T";
        }else{
            isOurs = "F";
        }
        Hospital hospital = hospitalService.saveByAdmin(id, hospitalName, doctorName, hospitalAddress, phoneNumber, isOurs );
        if(hospital != null) {
            redirectAttributes.addFlashAttribute("message", "병원이 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }else{
            redirectAttributes.addFlashAttribute("message", "해당 병원이 이미 존재합니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        }
        return "redirect:/admin/hospital/add";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteHospital(@PathVariable Long id) {
        Hospital hospital = hospitalService.getHospitalById(id);
        hospitalService.delete(hospital);
        return "redirect:/admin/hospital"; // 삭제 후 병원 리스트 페이지로 리다이렉트
    }
}
