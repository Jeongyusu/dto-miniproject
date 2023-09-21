package com.example.kakao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.kakao.cart.Cart;
import com.example.kakao.cart.CartJPARepository;
import com.example.kakao.cart.CartResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DataJpaTest
public class CartJPARepositoryTest2 {

    private final CartJPARepository cartJPARepository;

    @Test
    public CartResponse.FindAllByUserDTO testFindAllByUser() {

        // List<CartResponse.FindAllByUserDTO> responseDTOs =
        // cartJPARepository.findAllByUserId(sessionUser.getId()).stream()
        // .map(o->new CartResponse.FindAllByUserDTO(o.getOption().getProduct(),
        // cartJPARepository.findAllByUserId(sessionUser.getId())))
        // .collect(Collctors.toList());

        List<Cart> carts = cartJPARepository.findAllByUserId(1);
        System.out.println(carts.toString());
        return new CartResponse.FindAllByUserDTO(12100, carts);
    }
}
