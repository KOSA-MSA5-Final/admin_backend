package com.example.demo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
    public String allergyPage(HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "/allergy/Allergy"; // Allergy.html 페이지로 이동
    }

    @GetMapping("/product")
    public String productPage(HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "/product/Product"; // Product.html 페이지로 이동
    }

    @GetMapping("/hospital")
    public String hospitalPage(HttpSession session) {
        // 세션에 user 속성이 없는 경우 로그인 페이지로 리다이렉트
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "/hospital/Hospital"; // Hospital.html 페이지로 이동
    }
}
