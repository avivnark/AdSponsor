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


    public void updateCampaignStatus() {
        LocalDate tenDaysAgo = LocalDate.now().minusDays(10);
        // SQL query to update the statuses of campaigns where start_date is before tenDaysAgo
        String sql = "UPDATE campaigns SET active = FALSE WHERE start_date <= ?";
        jdbcTemplate.update(sql, tenDaysAgo);
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


    public Campaign createCampaignWithProducts(Campaign campaign) {
        Campaign savedCampaign = campaignRepository.save(campaign);
        int campaign_id = savedCampaign.getId();
        List<Integer> ids = savedCampaign.getIds();
        for (Integer product_id : ids) {
            String sql = "INSERT INTO Campaign_Products (campaign_id, product_id) VALUES (?, ?)";
            jdbcTemplate.update(sql, campaign_id, product_id);
        }
        updateCampaignStatus();
        return savedCampaign;
    }
}
