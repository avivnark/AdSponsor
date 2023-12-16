package com.example.AdSponsor.repository;
import com.example.AdSponsor.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface ProductRepository extends CrudRepository<Product, Integer> {


    @Query(value =
            "SELECT p.id, p.title, p.category, p.price, p.serial_number, c.bid " +
                    "FROM Products p " +
                    "LEFT JOIN Campaign_Products cp ON p.id = cp.product_id " +
                    "LEFT JOIN Campaigns c ON cp.campaign_id = c.id " +
                    "WHERE c.active = true " +
                    "ORDER BY CASE WHEN p.category = :category THEN 1 ELSE 0 END DESC, COALESCE(c.bid, 0) DESC " +
                    "LIMIT 1")
    Optional<Object[]> findPromotedProductWithHighestBidByCategory(@Param("category") String category);


}
