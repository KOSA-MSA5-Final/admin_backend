package com.example.demo.domains.admin.service;

import com.example.demo.domains.admin.entitiy.Admin;
import com.example.demo.domains.admin.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    public boolean login(String username, String password) {
        Optional<Admin> admin = adminRepository.findByName(username);
        if (admin.isPresent()) {
            Admin admin1 = admin.get();
            return admin1.getPassword().equals(password);
        }
        return false;
    }

    // 모든 Admin 엔티티를 조회하는 메서드
    @Transactional
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    public Optional<Admin> getAdminByName(String admin1) {
        return adminRepository.findByName(admin1);
    }

    public void deleteAll() {
        adminRepository.deleteAll();
    }
}
