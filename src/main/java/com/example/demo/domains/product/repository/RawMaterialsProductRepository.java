package com.example.demo.domains.product.repository;

import com.example.demo.domains.product.entity.RawMaterialsProduct;
import com.example.demo.domains.product.repository.querydsl.customs.RawMaterialsProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품-원료 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface RawMaterialsProductRepository extends JpaRepository<RawMaterialsProduct, Long>, RawMaterialsProductRepositoryCustom {

}
