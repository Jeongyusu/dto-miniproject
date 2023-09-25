package com.example.kakao.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;

import com.example.kakao.cart.Cart;
import com.example.kakao.cart.CartJPARepository;
import com.example.kakao.cart.CartResponse;
import com.example.kakao.product.Product;
import com.example.kakao.product.ProductJPARepository;
import com.example.kakao.product.option.OptionJPARepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    CartJPARepository cartJPARepository;

    @Autowired
    OptionJPARepository optionJPARepository;

    @Autowired
    ProductJPARepository productJPARepository;

    @Test
    public void findAllByUserId_test() {
        // Cart c1 = Cart.builder()
        //         .id(1)
        //         .price(2000)
        //         .build();

        // Cart c2 = Cart.builder()
        //         .id(2)
        //         .price(10000)
        //         .build();

        // List<Cart> cartList = Arrays.asList(c1, c2);
        // for (Cart cart : cartList) {
        //     System.out.println("테스트" + cart.getPrice());
        // }

        List<Cart> cartList = cartJPARepository.findAllByUserId(1);

        for (Cart cart : cartList) {
        System.out.println("테스트" + cart.getId());
        System.out.println("테스트" + cart.getPrice());
        System.out.println("테스트" + cart.getOption().getOptionName());
        }


    }

    // @Test
    // public void findAllByUser_test() {
    //     List<Cart> cartList = cartJPARepository.findAllByUserId(user.getId());
    //     List<CartResponse.FindAllByUserDTO> cartDTOList = cartList.stream()
    //             .map(cart -> {
    //                 new CartResponse.FindAllByUserDTO.ProductNameDTO(
    //                         cart.getProduct());
    //                 new CartResponse.FindAllByUserDTO.CartDetailDTO(
    //                         cart);
    //                 int totalPrice = calculateTotalPrice(cartDetailDTO);

    //                 return new CartResponse.FindAllByUserDTO(totalPrice, productNameDTO, cartDetailDTO);
    //             })
    //             .collect(Collectors.toList());

    //     System.out.println(cartDTOList.get(0).getCartDetailDTO().getCartId());
    // }

    // @Test
    // public void findByProductId_test() {
    //     List<Product> productList = productJPARepository.findByProductUserId(1);
    //     for (Product product : productList) {
    //         System.out.println("테스트" + product.getProductName());
    //     }
    // }
}
