package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;
import com.example.kakao.user.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CartResponse {


    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        
        private Integer totalPrice;
        private List<ProductDTO> productDTO;
    
            public FindAllByUserDTO(List<Product> productList, List<Cart> cartList) {
                this.totalPrice = cartList.stream()
                    .map(t -> t.getPrice())
                    .reduce(0, (a, b) -> a + b);
                this.productDTO = productList.stream()
                    .distinct()
                    .map(p -> new ProductDTO(p , cartList))
                    .collect(Collectors.toList());
            }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer productId;
            private String productName;
            private List<CartDetailDTO> cartDetailDTOs;

            public ProductDTO(Product product, List<Cart> cartList ) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.cartDetailDTOs = cartList.stream()
                    .filter(t -> t.getOption().getProduct().getId() == productId)
                    .map(t -> new CartDetailDTO(t))
                    .collect(Collectors.toList());
            }
        }

        @Getter
        @Setter
        public class CartDetailDTO {
            private Integer cartId;
            private String optionName;
            private Integer quantity;
            private Integer cartPrice;
            private Integer optionPrice;

            public CartDetailDTO(Cart cart) {
                this.cartId = cart.getId();
                this.optionName = cart.getOption().getOptionName();
                this.quantity = cart.getQuantity();
                this.cartPrice = cart.getPrice();
                this.optionPrice = cart.getOption().getPrice();
            }
        }
    }
}