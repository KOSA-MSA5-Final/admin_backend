package com.example.demo.controllers;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.service.impls.ProductDetailImgServiceImps;
import com.example.demo.domains.product.service.impls.ProductImgServiceImps;
import com.example.demo.domains.product.service.impls.ProductServiceImps;
import com.example.demo.domains.product.service.interfaces.ProductService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.AnimalServiceImpl;
import org.springframework.ui.Model;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {

    private final AnimalServiceImpl animalService;

    private final ProductServiceImps productService;

    private final ProductImgServiceImps productImgService;

    private final ProductDetailImgServiceImps productDetailImgService;

    @GetMapping("/add")
    public String showAddProduct(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "product/product-form";
    }

    @PostMapping("/add/product")
    public String addProduct(@RequestParam String productName,
                             String productMaker,
                             String productType,
                             Long productPrice,
                             String animalName,
                             String productOrigin,
                             String productAllRawmaterial,
                             String productIngredient,
                             String productCalories,
                             String productWeight,
                             String productAge,
                             String productFunction,
                             String productImageUrls,
                             String productDetailImageUrls,
                             String productSubtype, // 상품 상세 타입 추가
                             RedirectAttributes redirectAttributes) {

        // 이미지 URL들을 콤마로 분리하여 List<String>으로 변환
        String[] imageUrlList = productImageUrls.split(",");
        String[] detailImageUrlList = productDetailImageUrls.split(",");

        // 새로운 Product 객체 생성
        Product product = new Product();
        product.setName(productName);
        product.setMaker(productMaker);
        product.setType(productType);
        product.setSubtype(productSubtype); // product의 상세 타입 설정
        product.setPrice(productPrice);
        Animal animal = animalService.findAnimalByName(animalName);
        product.setAnimal(animal);
        product.setOrigin(productOrigin);
        product.setAll_rawmaterial(productAllRawmaterial);
        product.setIngredient(productIngredient);
        product.setCalories(productCalories);
        product.setWeight(productWeight);
        product.setAge_group(productAge);
        product.setFunction(productFunction);

        Product saveProduct = productService.saveProduct(product);

        if(saveProduct != null) {
            redirectAttributes.addFlashAttribute("message", "상품이 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }else{
            redirectAttributes.addFlashAttribute("message", "상품 추가에 실패했습니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        }

        for(String img : imageUrlList){
            productImgService.saveProductImg(img, saveProduct);
        }

        for(String detailImg : detailImageUrlList){
            productDetailImgService.saveProductDetailImg(detailImg, saveProduct);
        }

        return "redirect:/admin/product";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteHospital(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }

    // 상품 상세 페이지
    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id); // ID로 상품 조회
        List<String> imageUrls = productImgService.getImageUrlsByProduct(product); // 이미지 URL 목록 가져오기
        List<String> imageDetailUrls = productDetailImgService.getDetailImgsUrlsByProduct(product);
        if (product != null) {
            model.addAttribute("product", product); // 모델에 조회한 상품 추가
            model.addAttribute("imageUrls", imageUrls); // 이미지 URL 목록 추가
            model.addAttribute("imageDetailUrls", imageDetailUrls); // 이미지 URL 목록 추가
            return "product/product-detail"; // productDetails.html 뷰로 이동
        } else {
            return "redirect:/admin/product"; // 상품을 찾지 못하면 리스트 페이지로 리다이렉트
        }
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id); // ID로 상품 조회
        List<String> imageUrls = productImgService.getImageUrlsByProduct(product); // 이미지 URL 목록 가져오기
        List<String> imageDetailUrls = productDetailImgService.getDetailImgsUrlsByProduct(product);
        if (product != null) {
            model.addAttribute("product", product); // 모델에 조회한 상품 추가
            model.addAttribute("animals", animalService.getAllAnimals());
            model.addAttribute("imageUrls", imageUrls); // 이미지 URL 목록 추가
            model.addAttribute("imageDetailUrls", imageDetailUrls); // 이미지 URL 목록 추가

            // List<String>을 쉼표로 묶어서 하나의 문자열로 변환
            String imageUrlString = String.join(",", imageUrls);
            String imageDetailUrlString = String.join(",", imageDetailUrls);

            model.addAttribute("productImageUrls", imageUrlString);
            model.addAttribute("productDetailImageUrls", imageDetailUrlString);

            return "product/product-edit"; // edit.html
        } else {
            return "redirect:/admin/product"; // 상품을 찾지 못하면 리스트 페이지로 리다이렉트
        }
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        //productService.update(product);
        return "redirect:/admin/product"; // 수정 후 상품 목록으로 리디렉션
    }

}
