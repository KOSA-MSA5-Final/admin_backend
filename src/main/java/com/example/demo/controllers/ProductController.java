package com.example.demo.controllers;

import com.example.demo.domains.disease.service.impls.DiseaseNamesServiceImpl;
import com.example.demo.domains.product.entity.Allergy;
import com.example.demo.domains.product.entity.Product;
import com.example.demo.domains.product.service.impls.*;
import com.example.demo.domains.product.service.interfaces.ProductService;
import com.example.demo.domains.profile_medical.entity.Animal;
import com.example.demo.domains.profile_medical.entity.Hospital;
import com.example.demo.domains.profile_medical.service.impls.AnimalServiceImpl;
import com.example.demo.util.AwsS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.demo.domains.profile_medical.service.interfaces.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.domains.product.dto.ProductDTO;

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

    private final AllergyServiceImps allergyService;

    private final RawMaterialServiceImps rawMaterialService;

    private final DiseaseNamesServiceImpl diseaseService;

    private final DiseaseProductServiceImps diseaseProductServiceImps;

    private final AwsS3Service awsS3Service;

    @GetMapping("/add")
    public String showAddProduct(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        model.addAttribute("allergies", allergyService.getAllAllergies());
        model.addAttribute("diseases", diseaseService.findAllDiseases());
        return "product/product-form";
    }

    @PostMapping("/add/product")
    public String addProduct(@ModelAttribute ProductDTO productDto, Model model,
                             RedirectAttributes redirectAttributes) {

        // 이미지 파일을 S3에 업로드하고 URL을 가져오는 로직
        //String productImageUrl = uploadImageToS3(productImage); // 단일 이미지 업로드
        List<String> productImage = awsS3Service.uploadFile(productDto.getProductImageUrls());
        List<String> detailImageUrls = awsS3Service.uploadFile(productDto.getProductDetailImageUrls()); // 다중 이미지 업로드

        // 새로운 Product 객체 생성
        Product product = new Product();
        product.setName(productDto.getProductName());
        product.setMaker(productDto.getProductMaker());
        product.setType(productDto.getProductType());
        product.setSubtype(productDto.getProductSubtype()); // product의 상세 타입 설정
        product.setPrice(productDto.getProductPrice());
        Animal animal = animalService.findAnimalByName(productDto.getAnimalName());
        product.setAnimal(animal);
        product.setOrigin(productDto.getProductOrigin());
        product.setAll_rawmaterial(productDto.getProductAllRawmaterial());
        product.setIngredient(productDto.getProductIngredient());
        product.setCalories(productDto.getProductCalories());
        product.setWeight(productDto.getProductWeight());
        product.setAge_group(productDto.getProductAge());
        product.setFunction(productDto.getProductFunction());
        List<MultipartFile> m = new ArrayList<>();
        m.add(productDto.getProductMainImageUrls());
        product.setMain_image_url(awsS3Service.uploadFile(m).getFirst());

        Product saveProduct = productService.saveProduct(product);

        if(saveProduct != null) {
            redirectAttributes.addFlashAttribute("message", "상품이 성공적으로 추가되었습니다.");
            redirectAttributes.addFlashAttribute("alertType", "success");
        }else{
            redirectAttributes.addFlashAttribute("message", "상품 추가에 실패했습니다.");
            redirectAttributes.addFlashAttribute("alertType", "error");
        }

        for(long i : productDto.getProductAllergies()) {
            rawMaterialService.createRawMaterial(saveProduct, allergyService.findById(i));
        }

        for(long i : productDto.getDiseaseNames()){
            diseaseProductServiceImps.createDiseaseProduct(diseaseService.findById(i), saveProduct);
        }

        for(String img : productImage){
            productImgService.saveProductImg(img, saveProduct);
        }

        for(String detailImg : detailImageUrls){
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
        List<String> allergies = rawMaterialService.getAllagyName(product);
        List<String> diseases = diseaseProductServiceImps.getDiseaseName(product);
        if (product != null) {
            model.addAttribute("product", product); // 모델에 조회한 상품 추가
            model.addAttribute("imageUrls", imageUrls); // 이미지 URL 목록 추가
            model.addAttribute("imageDetailUrls", imageDetailUrls); // 이미지 URL 목록 추가
            model.addAttribute("allergies", allergies);
            model.addAttribute("diseases", diseases);
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
        List<String> allergies = rawMaterialService.getAllagyName(product);
        List<String> diseases = diseaseProductServiceImps.getDiseaseName(product);
        if (product != null) {
            model.addAttribute("product", product); // 모델에 조회한 상품 추가
            model.addAttribute("animals", animalService.getAllAnimals());
            model.addAttribute("imageUrls", imageUrls); // 이미지 URL 목록 추가
            model.addAttribute("imageDetailUrls", imageDetailUrls); // 이미지 URL 목록 추가
            model.addAttribute("allergies", allergyService.getAllAllergies());
            model.addAttribute("diseases", diseaseService.findAllDiseases());

            model.addAttribute("select_allergies", allergies);
            model.addAttribute("select_diseases", diseases);

            return "product/product-edit"; // edit.html
        } else {
            return "redirect:/admin/product"; // 상품을 찾지 못하면 리스트 페이지로 리다이렉트
        }
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute ProductDTO productDto) {
        productService.update(id, productDto);
        return "redirect:/admin/product"; // 수정 후 상품 목록으로 리디렉션
    }

    @GetMapping("/main")
    public String productMain(Model model) {
        return "product/product-main";
    }

}
