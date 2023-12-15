package com.example.AdSponsor.controller;

<<<<<<< HEAD
import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.service.CampaignService;
=======
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.service.CampaignService;
import com.example.AdSponsor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 0b7d5b4 (sql)
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> 0b7d5b4 (sql)
@RestController
public class ProductController {

    private final CampaignService CampaignService;

<<<<<<< HEAD
=======
    @Autowired
>>>>>>> 0b7d5b4 (sql)
    public ProductController(CampaignService campaignService) {
        CampaignService = campaignService;
    }


    @GetMapping("/products/{id}")
    public Product GetProduct(@PathVariable Integer id){
        Product product = CampaignService.getProduct(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }


    @DeleteMapping("/product/{id}")
    public void DeleteProduct(@PathVariable Integer id){
        CampaignService.removeProduct(id);
    }

    @GetMapping("/products")
    public Iterable<Product> GetProducts(){
        return CampaignService.getProducts();
    }

<<<<<<< HEAD
    @PostMapping("/product/")
    public Product CreateProduct(@RequestBody Product product){
        //product = ProductService.add();
        return product;
    }
=======

>>>>>>> 0b7d5b4 (sql)

}
