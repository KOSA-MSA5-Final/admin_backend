package com.example.demo.controllers;

import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.service.impls.AllergyServiceImps;
import com.example.demo.domains.product.service.impls.ProductServiceImps;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.HospitalServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HospitalServiceImpl hospitalService;
    private final ProductServiceImps productService;
    private final AllergyServiceImps allergyService;

    @GetMapping
    public String adminPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "admin";
    }

    @GetMapping("/animal")
    public String animalPage(HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "animal/Animal"; // Animal.html 페이지로 이동
    }

    @GetMapping("/disease")
    public String diseasePage(HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "/disease/Disease"; // Disease.html 페이지로 이동
    }

    @GetMapping("/allergy")
    public String allergyPage(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Allergy> allergies = allergyService.getAllAllergies();
        model.addAttribute("allergies", allergies);

        return "/allergy/Allergy"; // Allergy.html 페이지로 이동
    }

    @GetMapping("/product")
    public String productPage(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Product> products = productService.getAllProducts();
        model.addAttribute("product", products);

        return "/product/Product"; // Product.html 페이지로 이동
    }

    @GetMapping("/hospital")
    public String hospitalPage(Model model, HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Hospital> hospitals = hospitalService.getAll();
        model.addAttribute("hospitals", hospitals);

        return "/hospital/Hospital"; // Hospital.html 페이지로 이동
    }
}
