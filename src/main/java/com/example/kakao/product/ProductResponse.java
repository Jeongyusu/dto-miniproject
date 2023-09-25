package com.example.kakao.product;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProductResponse {

   // (기능1) 상품 목록보기
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer productId;
        private String productName;
        private List<String> productImages; // 이미지 URL을 리스트로 저장
        private String productDescription;
        private Integer productPrice;

        public FindAllDTO(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.productImages = Arrays.asList(product.getImage().split(",")); // 이미지 URL을 쉼표로 분리하여 리스트로 저장
            this.productDescription = product.getDescription();
            this.productPrice = product.getPrice();
        }
    }

  
}