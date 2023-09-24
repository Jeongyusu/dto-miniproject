package com.example.kakao.order.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakao.order.Order;

public interface ItemJPARepository extends JpaRepository<Item, Integer> {
    List<Item> findByOrder(Order order);
}
