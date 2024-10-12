package com.example.demo.domains.product.repository.querydsl.customs;

import com.example.demo.domains.product.entity.Product;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 커스텀 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface ProductRepositoryCustom {
    List<Product> findAllByType(String type);
}
