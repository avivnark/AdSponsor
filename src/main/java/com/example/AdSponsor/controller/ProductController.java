package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProductController {

    private Map<String, Product> dbProducts = new HashMap<>();

    @GetMapping("/products")
    public Collection<Product> GetProducts(){
        return dbProducts.values();
    }

    @PostMapping("/product/")
    public Product CreateProduct(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString());
        dbProducts.put(product.getId(), product);
        return product;
    }



}
