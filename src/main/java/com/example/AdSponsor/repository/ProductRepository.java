package com.example.AdSponsor.repository;
import com.example.AdSponsor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(@Param("category") String category);
    Product findByProductSerialNumber(@Param("serialNumber") String serialNumber);
    @Query("SELECT p FROM Product p WHERE p.price <= :maxPrice")
    List<Product> findProductsByPriceLessThanEqual(@Param("maxPrice") double maxPrice);
    boolean existsByProductSerialNumber(@Param("serialNumber") String serialNumber);
    List<Product> findActiveProducts(); // Retrieves products with active campaigns
    @Query(value = "SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findByCategoryOptimized(@Param("category") String category);
}
