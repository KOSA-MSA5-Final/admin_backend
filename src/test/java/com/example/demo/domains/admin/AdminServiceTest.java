package com.example.demo.domains.admin;

import com.example.demo.domains.admin.entitiy.Admin;
import com.example.demo.domains.admin.service.AdminService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        // 데이터 추가
        Admin admin = new Admin();
        admin.setName("a");
        admin.setPassword("1234");
        adminService.save(admin);
    }

//    @AfterEach
//    public void tearDown() {
//        // 데이터 정리
//        adminService.deleteAll(); // 모든 Admin 데이터를 삭제하는 메소드 필요
//    }

    @Test
    public void testGetAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        assertFalse(admins.isEmpty()); // 데이터가 존재해야 합니다.
    }

//    @Test
//    public void testGetAdminByName() {
//        Optional<Admin> admin = adminService.getAdminByName("admin");
//        assertTrue(admin.isPresent()); // 존재하는 데이터여야 합니다.
//    }
}
