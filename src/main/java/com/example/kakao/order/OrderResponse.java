package com.example.kakao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.order.item.Item;
import com.example.kakao.product.Product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderResponse {

    // (기능4) 주문상품 정보조회 (유저별)
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {

    }

    // (기능5) 주문결과 확인
    @Data
    public static class FindByIdDTO {
        // 주문 번호
        private int orderId;
        // 총 주문 금액
        private int totalPrize;
        // 주문 Product 목록
        private List<OrderProductDTO> items = new ArrayList<>();

        /**
         * @param orderId    주문 번호
         * @param orderItems Option으로 감싸진 실제 주문 상품 목록. Product 와 Item.Option.Product로 매핑
         */
        public FindByIdDTO(int orderId, List<Item> orderItems) {
            this.orderId = orderId;

            orderItems.stream()
                    // 주문 Product 꺼내기
                    .map(item -> item.getOption().getProduct())
                    // 중복 제거
                    .distinct()
                    // 각 주문 Product 별로 주문한 Option 들 grouping
                    .forEach(product -> {
                        List<Item> list = orderItems.stream()
                                .filter(item -> item.getOption().getProduct().getId() == product.getId())
                                .collect(Collectors.toList());
                        this.items.add(new OrderProductDTO(product, list));
                    });

            // 전체 금액 계산
            this.totalPrize = this.items.stream()
                    .mapToInt(orderProductDTO -> orderProductDTO.getOptions().stream()
                            .mapToInt(OptionDTO::getTotalPrice).sum())
                    .sum();
        }

        @Data
        public static class OrderProductDTO {
            // 주문 Product 번호
            private int productId;
            // 주문 Product 이름
            private String productName;
            // 주문 Product의 선택 Option 목록
            private List<OptionDTO> options;

            // 주문한 Product에 해당하는 Item들을 이용하여 해당 Product의 어떤 Option 들을 주문했는지 담기
            public OrderProductDTO(Product product, List<Item> items) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.options = items.stream()
                        .map(OptionDTO::new)
                        .collect(Collectors.toList());
            }
        }

        @Data
        public static class OptionDTO {
            private int optionId;
            private String optionName;
            private int quantity;
            private int totalPrice;

            public OptionDTO(Item item) {
                this.optionId = item.getOption().getId();
                this.optionName = item.getOption().getOptionName();
                this.quantity = item.getQuantity();
                this.totalPrice = item.getPrice();
            }
        }
    }
}
