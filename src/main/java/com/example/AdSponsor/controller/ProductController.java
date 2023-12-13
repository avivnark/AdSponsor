package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private Map<String, Product> dbproducts = new HashMap<>();

    @GetMapping("/products")
    public Collection<Product> get(){
        return dbproducts.values();
    }

    @PostMapping("/product/")
    public Product create(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString());
        dbproducts.put(product.getId(), product);
        return product;
    }



}
