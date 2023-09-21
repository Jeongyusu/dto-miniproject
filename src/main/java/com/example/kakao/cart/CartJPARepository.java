package com.example.kakao.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {
    @Query("select c from Cart c where c.user.id = :userId")
    public List<Cart> findAllByUserId(@Param("userId") Integer userId);

    void deleteByUserId(int userId);
}
