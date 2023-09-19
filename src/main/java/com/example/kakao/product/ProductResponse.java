package com.example.kakao.product;

import java.util.ArrayList;
import java.util.List;

import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {

    }

    // (기능2) 상품 상세보기
    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer productId;
        private String productName;
        private Integer price;
        private String porudctImageName;
        private Integer starCount;
        private String deliveryMethod;
        private String deliveryPrice;
        private List<Option> productOptions = new ArrayList<>();

        public FindByIdDTO(Product product, Integer starCount, String deliveryMethod, String deliveryPrice) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.price = product.getPrice();
            this.porudctImageName = product.getImage();
            this.starCount = starCount;
            this.deliveryMethod = deliveryMethod;
            this.deliveryPrice = deliveryPrice;
            this.productOptions = product.getOptions();
        }

    }

}