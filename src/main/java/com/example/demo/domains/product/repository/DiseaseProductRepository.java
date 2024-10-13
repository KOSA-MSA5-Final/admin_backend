package com.example.demo.domains.product.repository;

import com.example.demo.domains.product.entity.DiseaseProduct;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.repository.querydsl.customs.DiseaseProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-10-01
 * description : 병명-상품 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-10-01         윤다희          최초 생성
 */

public interface DiseaseProductRepository extends JpaRepository<DiseaseProduct, Long> , DiseaseProductRepositoryCustom {
    List<DiseaseProduct> findByProduct(Product product);
}
