package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:80")
@RequestMapping("/api") // 수정: 전체 경로가 "/api"로 시작하도록 설정
public class MainController {

    @GetMapping("/message") // 수정: /api/message 경로로 매핑
    public String testController(){
        return "Backend is HERE!!!!";
    }
}
