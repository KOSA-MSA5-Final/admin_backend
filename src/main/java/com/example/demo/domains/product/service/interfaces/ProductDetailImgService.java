package com.example.demo.domains.product.service.interfaces;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.entity.ProductDetailImg;

import java.util.List;

/**
 * author : 윤다희
 * date : 2024-09-24
 * description : 상품 상세 이미지 서비스 인터페이스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24         윤다희          최초 생성
 */

public interface ProductDetailImgService {
    List<ProductDetailImg> getAllProductDetailImgs();
    ProductDetailImg saveProductDetailImg(String imageUrl, Product product);
    void deleteProductDetailImg(long id);
}
