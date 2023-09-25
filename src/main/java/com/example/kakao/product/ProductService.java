package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {

    private final ProductJPARepository productJPARepository;

  // (기능1) 상품 목록보기 (페이지당 상품 수 9개씩)
    public List<ProductResponse.FindAllDTO> findAll(int page) {

        int pageSize = 9; 
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productJPARepository.findAll(pageable); 
        List<ProductResponse.FindAllDTO> productPS = productPage.getContent()
                .stream()
                .map(ProductResponse.FindAllDTO::new)
                .collect(Collectors.toList());

        return productPS;
    }
  
}
