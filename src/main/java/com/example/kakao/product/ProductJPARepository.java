package com.example.kakao.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {

    @Query(value="SELECT * FROM PRODUCT_TB pt left outer join Option_tb ot on pt.id = ot.product_id left outer join cart_tb ct on ot.id = ct.option_id where ct.user_id =:id",nativeQuery = true)
    List<Product> findByProductUserId(@Param("id") Integer id);

    // @Query("select p from Product p where p.id = :id")
    // List<Product> findByProductId(@Param("id") Integer id);
}
