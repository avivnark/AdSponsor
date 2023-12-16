package com.example.AdSponsor.repository;

import com.example.AdSponsor.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends CrudRepository<Product, Integer> {


    @Query(value = "SELECT p.id, p.title, p.category, p.price, p.serial_number, c.bid " +
            "FROM Products p " +
            "LEFT JOIN Campaign_Products cp ON p.id = cp.product_id " +
            "LEFT JOIN Campaigns c ON cp.campaign_id = c.id " +
            "WHERE p.category = :category AND c.active = true " +
            "   OR p.category IS NULL AND c.active = true " +
            "ORDER BY COALESCE(p.category = :category, 0) DESC, COALESCE(c.bid, 0) DESC " , nativeQuery = true)
    Optional<Object[]> findPromotedProductWithHighestBidByCategory(@Param("category") String category);


}
