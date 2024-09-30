package com.example.demo.controllers;

import com.example.demo.domains.admin.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    private final AdminService adminService;

    public AdminLoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String adminLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session){
        System.out.println(adminService.getAllAdmins());
        if(adminService.login(username, password)){
            session.setAttribute("user", username);
            return "redirect:/admin";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String adminLogout(HttpSession session){
        session.invalidate();
        // 추가적인 로그아웃 처리 (예: SecurityContextHolder 비우기)
        SecurityContextHolder.clearContext();
        return "redirect:/login";
    }

}
