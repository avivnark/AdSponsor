package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.repository.CampaignRepository;
import com.example.AdSponsor.repository.ProductRepository;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ProductController {

    private final CampaignService campaignService;
    private final ProductRepository productRepository;

    public ProductController(CampaignService campaignService, ProductRepository productRepository) {
        this.campaignService = campaignService;
        this.productRepository = productRepository;
    }


    @GetMapping("/products/{id}")
    public Product GetProduct(@PathVariable Integer id){
        Product product = campaignService.getProduct(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }


    @DeleteMapping("/product/{id}")
    public void DeleteProduct(@PathVariable Integer id){
        campaignService.removeProduct(id);
    }

    @GetMapping("/products")
    public Iterable<Product> GetProducts(){
        return campaignService.getProducts();
    }

    @GetMapping("/ads/serveAd/{category}")
    public Object[] getPromotedProductWithHighestBidByCategory(@PathVariable String category) {
        campaignService.updateCampaignStatus();
        return productRepository.findPromotedProductWithHighestBidByCategory(category)
                .orElse(null);
    }



}
