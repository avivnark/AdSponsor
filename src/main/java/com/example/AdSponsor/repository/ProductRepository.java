package com.example.AdSponsor.repository;

import com.example.AdSponsor.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
