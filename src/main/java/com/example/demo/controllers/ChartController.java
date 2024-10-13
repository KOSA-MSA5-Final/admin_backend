package com.example.demo.controllers;

import com.example.demo.domains.admin.dto.AnimalDiseaseDTO;
import com.example.demo.domains.disease.entity.DiseaseSub;
import com.example.demo.domains.disease.service.impls.DiseaseSubProfileServiceImpl;
import com.example.demo.domains.disease.service.impls.DiseaseSubServiceImpl;
import com.example.demo.domains.disease.service.interfaces.DiseaseSubProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/chart")
@RequiredArgsConstructor
public class ChartController {

    @Autowired
    private DiseaseSubProfileServiceImpl diseaseSubProfileService;

    @Autowired
    private DiseaseSubServiceImpl subService;

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
}
