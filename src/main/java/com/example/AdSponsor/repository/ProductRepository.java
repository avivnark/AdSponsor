package com.example.AdSponsor.repository;

import com.example.AdSponsor.model.Product;
<<<<<<< HEAD
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    // Query to find promoted products by category and order by bid descending
    @Query("SELECT p FROM Product p JOIN p.campaign c WHERE c.category = :category AND c.active = true ORDER BY p.bid DESC")
    List<Product> findPromotedProductsByCategoryOrderByBidDesc(String category);

    // Query to find the top product with the highest bid overall
    Product findTopByOrderByBidDesc();
>>>>>>> 0b7d5b4 (sql)
}
