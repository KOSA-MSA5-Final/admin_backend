package com.example.demo.controllers;

import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.service.impls.ProductDetailImgServiceImps;
import com.example.demo.domains.product.service.impls.ProductImgServiceImps;
import com.example.demo.domains.product.service.impls.ProductServiceImps;
import com.example.demo.domains.product.service.interfaces.ProductService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.service.impls.AnimalServiceImpl;
import org.springframework.ui.Model;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
                             ArrayList<String> imageUrlList, // 수정된 부분
                             ArrayList<String> detailImageUrlList, // 수정된 부분
                             RedirectAttributes redirectAttributes) {
        // 새로운 Product 객체 생성
        Product product = new Product();
        product.setName(productName);
        product.setMaker(productMaker);
        product.setType(productType);
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
            System.out.println(img+"**********************************************************");
            productImgService.saveProductImg(img, saveProduct);
        }

        for(String detailImg : detailImageUrlList){
            System.out.println(detailImg+"**********************************************************");
            productDetailImgService.saveProductDetailImg(detailImg, saveProduct);
        }

        return "redirect:/admin/product";
    }
}
