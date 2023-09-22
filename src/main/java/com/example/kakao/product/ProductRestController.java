package com.example.kakao.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakao._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    // (기능1) 상품 목록보기
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // (기능2) 상품 상세보기
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {

        return null;
    }



    // -----------------------------

        
        @GetMapping("/products/{id}/v1")
    public ResponseEntity<?> findByIdv1(@PathVariable int id) {
        
        return null;
    }

        @GetMapping("/products/{id}/v2")
    public ResponseEntity<?> findByIdv2(@PathVariable int id) {
        
        return null;
    }

        @GetMapping("/products/{id}/v3")
    public ResponseEntity<?> findByIdv3(@PathVariable int id) {
        
        return null;
    }
}