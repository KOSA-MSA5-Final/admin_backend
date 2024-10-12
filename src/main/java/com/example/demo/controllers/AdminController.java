package com.example.demo.controllers;

import com.example.demo.domains.disease.entity.DiseaseNames;
import com.example.demo.domains.disease.service.impls.DiseaseNamesServiceImpl;
import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.service.impls.AllergyServiceImps;
import com.example.demo.domains.product.service.impls.ProductServiceImps;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.AnimalServiceImpl;
import com.example.demo.domains.profile_medical.service.impls.HospitalServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HospitalServiceImpl hospitalService;
    private final ProductServiceImps productService;
    private final AllergyServiceImps allergyService;
    private final DiseaseNamesServiceImpl diseaseNamesService;
    private final AnimalServiceImpl animalService;

    @GetMapping
    public String adminPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "admin";
    }

    @GetMapping("/animal")
    public String animalPage(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);

        return "animal/Animal"; // Animal.html 페이지로 이동
    }

    @GetMapping("/disease")
    public String diseasePage(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<DiseaseNames> diseaseNames = diseaseNamesService.findAllDiseases();
        model.addAttribute("diseases", diseaseNames);

        return "/disease/Disease"; // Disease.html 페이지로 이동
    }

    @GetMapping("/allergy")
    public String allergyPage(@RequestParam(required = false) String type, Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Allergy> allergies;

        if (type != null && !type.isEmpty()) {
            allergies = allergyService.findByType(type); // 대분류에 따른 필터링
        } else {
            allergies = allergyService.getAllAllergies(); // 전체 알러지 리스트
        }

        model.addAttribute("allergies", allergies);

        return "/allergy/Allergy"; // Allergy.html 페이지로 이동
    }

    @GetMapping("/product")
    public String productPage(@RequestParam(defaultValue = "all") String category, Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Product> products;

        // 선택된 카테고리에 따라 상품 필터링
        if ("feed".equals(category)) {
            products = productService.findByType("feed");
        } else if ("snack".equals(category)) {
            products = productService.findByType("snack");
        } else if ("supplement".equals(category)) {
            products = productService.findByType("supplement");
        } else {
            products = productService.getAllProducts(); // 전체 상품
        }

        model.addAttribute("product", products);
        model.addAttribute("selectedCategory", category);

        return "/product/Product"; // Product.html 페이지로 이동
    }

    @GetMapping("/hospital")
    public String hospitalPage(@RequestParam(value = "filter", required = false, defaultValue = "all") String filter, Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Hospital> hospitals;

        if ("true".equals(filter)) {
            // 제휴 병원만 조회
            hospitals = hospitalService.findByIsOurs("T");
        } else if ("false".equals(filter)) {
            // 비제휴 병원만 조회
            hospitals = hospitalService.findByIsOurs("F");
        } else {
            // 전체 조회
            hospitals = hospitalService.getAll();
        }

        model.addAttribute("hospitals", hospitals);

        return "/hospital/Hospital"; // Hospital.html 페이지로 이동
    }
}
