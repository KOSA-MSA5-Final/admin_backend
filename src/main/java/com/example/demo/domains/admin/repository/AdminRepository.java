package com.example.demo.domains.admin.repository;

import com.example.demo.domains.admin.entitiy.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByName(String name);
}
