package com.example.demo.domains.product.repository.querydsl.impls;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.ProductImg;
import com.example.demo.domains.product.repository.ProductImgRepository;
import com.example.demo.domains.product.repository.querydsl.customs.ProductImgRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 이미지 레포지토리 구현
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

@RequiredArgsConstructor
public class ProductImgRepositoryImpl implements ProductImgRepositoryCustom {

    private final EntityManager em;


    @Override
    public List<String> findByProduct(Product product) {
        // JPQL 쿼리를 작성하여 ProductImg 엔티티에서 이미지 URL을 조회
        String jpql = "SELECT pi.imageUrl FROM ProductImg pi WHERE pi.product = :product";

        // 쿼리 실행
        return em.createQuery(jpql, String.class)
                .setParameter("product", product)
                .getResultList();
    }
}
