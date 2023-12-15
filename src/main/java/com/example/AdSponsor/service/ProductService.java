package com.example.AdSponsor.service;

import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository; // Assuming you have a ProductRepository

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getPromotedProduct(String category) {
        // Retrieve the promoted product with the highest bid for the specified category
        List<Product> products = productRepository.findPromotedProductsByCategoryOrderByBidDesc(category);

        if (!products.isEmpty()) {
            return products.get(0); // Return the first product (with highest bid) found in the list
        }

        // If no promoted products found for the specified category, get the product with the highest bid overall
        return productRepository.findTopByOrderByBidDesc();
    }
}
