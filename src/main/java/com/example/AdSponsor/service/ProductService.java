package com.example.AdSponsor.service;

import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private Map<String, Product> dbProducts = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;


    public Product getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Map<String, Product> get() {
        return dbProducts;
    }

    public Product get(String id) {
        return dbProducts.get(id);
    }

    public Product remove(String id) {
        return dbProducts.remove(id);
    }
}
