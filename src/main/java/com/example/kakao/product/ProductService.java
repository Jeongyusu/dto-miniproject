package com.example.kakao.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.order.OrderResponse.FindByIdDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;

    // (기능1) 상품 목록보기
    public List<ProductResponse.FindAllDTO> findAll(int page) {
        return null;
    }

    // (기능2) 상품 상세보기
    public ProductResponse.FindByIdDTO findById(int id) {
        Product product = productJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 제품을 찾을 수 없습니다 : " + id));
        ProductResponse.FindByIdDTO findByIdDTO = new ProductResponse.FindByIdDTO(product, 4, "택배배송", "무료배송");
        return findByIdDTO;
    }
}
