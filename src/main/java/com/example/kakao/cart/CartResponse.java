package com.example.kakao.cart;

import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// public class CartResponse {

//     // (기능3) 장바구니 조회
//     @ToString
//     @Getter
//     @Setter
//     public static class FindAllByUserDTO {
//         private Integer totalPrice;
//         private List<ProductDTO> products;

//         public FindAllByUserDTO(Integer totalPrice, List<Cart> cartList) {
//             this.totalPrice = totalPrice;
//             this.products = cartList.stream()
//                     .map(o -> new ProductDTO(o))
//                     .collect(Collectors.toList());
//         }

//     }

//     @Getter
//     @Setter
//     public class ProductDTO {
//         private String productName;
//         private List<CartDTO> carts;

//         public ProductDTO(List<Cart> cartList) {
//             this.productName = cartList.get(0).getOption().getProduct().getProductName();
//             this.carts = cartList.stream()
//                     .map(o -> new CartDTO(o))
//                     .collect(Collectors.toList());
//         }

//         public class CartDTO {
//             private String optionName;
//             private Integer quantity;
//             private Integer cartPrice;
//             private Integer optionPrice;

//             public CartDTO(Cart cart) {

//                 this.quantity = cart.getQuantity();
//                 this.cartPrice = cart.getPrice();
//                 this.optionPrice = cart.getOption().getPrice();
//             }

//         }

//     }

// }
public class CartResponse {
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(List<Product> productList, List<Cart> cartList) {
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getPrice()).sum();
            this.products = productList.stream()
                    .distinct()
                    .map(o -> new ProductDTO(o, cartList))
                    .collect(Collectors.toList());

        }

        @Getter
        @Setter
        public class ProductDTO {
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> cartList) {
                this.productName = product.getProductName();
                this.carts = cartList.stream()
                        .map(cart -> new CartDTO(cart))
                        .collect(Collectors.toList());
            }

            public class CartDTO {
                private String optionName;
                private Integer quantity;
                private Integer cartPrice;
                private Integer optionPrice;

                public CartDTO(Cart cart) {
                    this.optionName = cart.getOption().getOptionName();
                    this.quantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                    this.optionPrice = cart.getOption().getPrice();
                }
            }
        }
    }
}
