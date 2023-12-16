package com.example.AdSponsor.service;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.model.Product;
import com.example.AdSponsor.repository.CampaignRepository;
import com.example.AdSponsor.repository.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final ProductRepository productRepository;
    private final JdbcTemplate jdbcTemplate;



    public CampaignService(CampaignRepository campaignRepository, ProductRepository productRepository, JdbcTemplate jdbcTemplate) {
        this.campaignRepository = campaignRepository;
        this.productRepository = productRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Iterable<Campaign> getCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaign(Integer id) {
        return campaignRepository.findById(id).orElse(null);
    }

    public void removeCampaign(Integer id) {
        campaignRepository.deleteById(id);
    }

    public Campaign addCampaign(String name, LocalDate startDate, List<Integer> ids, BigDecimal bid) {
        Campaign campaign = new Campaign(name, startDate, ids, bid);
        campaignRepository.save(campaign);
        return campaign;
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }

    private void associateCampaignWithProduct(Integer campaignId, Integer productId) {
        String sql = "INSERT INTO Campaign_Products (campaign_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, campaignId, productId);
    }

    public Campaign createCampaignWithProducts(Campaign campaign, List<Integer> ids) {
        Campaign savedCampaign = campaignRepository.save(campaign);
        int campaign_id = savedCampaign.getId();

        for (Integer product : ids) {
            associateCampaignWithProduct(campaign_id, product);
        }

        return savedCampaign;
    }
}
