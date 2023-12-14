package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ProductController {

    private final ProductService ProductService;

    public ProductController(@Autowired ProductService productService) {
        ProductService = productService;
    }


    @GetMapping("/products/{id}")
    public Product GetProduct(@PathVariable String id){
        Product product = ProductService.get(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }

    @DeleteMapping("/campaigns/{id}")
    public void DeleteProduct(@PathVariable String id){
        Product product = ProductService.remove(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products")
    public Collection<Product> GetProducts(){
        return ProductService.get().values();
    }


    @PostMapping("/product/")
    public Product CreateProduct(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString());
        ProductService.get().put(product.getId(), product);
        return product;
    }

}
