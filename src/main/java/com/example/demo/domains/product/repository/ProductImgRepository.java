package com.example.demo.domains.product.repository;

import com.example.demo.domains.product.entity.ProductImg;
import com.example.demo.domains.product.repository.querydsl.customs.ProductImgRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 이미지 레포지토리
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface ProductImgRepository extends JpaRepository<ProductImg, Long>, ProductImgRepositoryCustom {

}
