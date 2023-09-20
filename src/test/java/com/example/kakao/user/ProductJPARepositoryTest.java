package com.example.kakao.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.product.Product;
import com.example.kakao.product.ProductJPARepository;
import com.example.kakao.product.ProductResponse;

@DataJpaTest
public class ProductJPARepositoryTest {

    // @Autowired
    // private ProductJPARepository productJPARepository;

    // @Test
    // public ProductResponse.FindByIdDTO findById() {
    // Product product = productJPARepository.findById(2)
    // .orElseThrow(() -> new Exception404("해당 제품을 찾을 수 없습니다 : " + 2));
    // ProductResponse.FindByIdDTO findByIdDTO = new
    // ProductResponse.FindByIdDTO(product, 4, "택배배송", "무료배송");
    // System.out.println(1);
    // System.out.println(findByIdDTO.getProductId());
    // System.out.println(findByIdDTO.getProductName());
    // System.out.println(findByIdDTO.getPrice());

    // return findByIdDTO;
    // }

}
