package com.example.demo.controllers;

import com.example.demo.domains.admin.dto.AnimalDiseaseDTO;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.service.impls.DiseaseSubProfileServiceImpl;
import com.example.demo.domains.disease.service.impls.DiseaseSubServiceImpl;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubProfileService;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.HospitalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/chart")
@RequiredArgsConstructor
public class ChartController {

    @Autowired
    private DiseaseSubProfileServiceImpl diseaseSubProfileService;

    @Autowired
    private DiseaseSubServiceImpl subService;

    @Autowired
    private HospitalServiceImpl hospitalService;

    @GetMapping("/1")
    public String showChart(Model model) {
        List<AnimalDiseaseDTO> chartData = diseaseSubProfileService.getAnimalTypeCountByDiseaseSub();

        for(AnimalDiseaseDTO a : chartData) {
            System.out.println(a.getAnimalName() + ":" + a.getDiseaseName());
        }
        model.addAttribute("chartData", chartData);
        return "chart/chart"; // chart.html
    }

    @GetMapping("/2")
    public String showChart2(Model model) {
        List<AnimalDiseaseDTO> chartData = diseaseSubProfileService.getAnimalTypeCountByDiseaseSub();
        List<DiseaseSub> list = subService.findAllDiseaseSubs();

        for(AnimalDiseaseDTO a : chartData) {
            System.out.println(a.getAnimalName() + ":" + a.getDiseaseName());
        }
        model.addAttribute("chartData", chartData);
        model.addAttribute("list", list);
        return "chart/chart-pi"; // chart.html
    }

    @GetMapping("/3")
    public String showChart3(Model model) {
        List<Hospital> hospitals = hospitalService.getAllOurHospitals();
        System.out.println(hospitals.getFirst().getName());

        // 구별 카운트를 저장할 맵
        Map<String, Integer> districtCount = new HashMap<>();

        // 주소에서 구 추출 및 카운트
        for (Hospital hospital : hospitals) {
            String district = extractDistrict(hospital.getAddress());
            if (district != null) {
                districtCount.put(district, districtCount.getOrDefault(district, 0) + 1);
            }
        }

        model.addAttribute("districtCount", districtCount);
        return "chart/chart-3"; // chart.html
    }

    // 주소에서 구를 추출하는 메서드
    private static String extractDistrict(String address) {
        String regex = "서울\\s([^\\s]+구)"; // 서울 뒤에 '구'로 끝나는 단어 추출
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(address);
        if (matcher.find()) {
            return matcher.group(1); // 구 이름 반환
        }
        return null; // 구가 없으면 null 반환
    }
}
