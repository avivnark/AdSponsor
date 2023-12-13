package com.example.AdSponsor.service;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> findAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign findCampaignById(String id) {
        return campaignRepository.findById(id).orElse(null);
    }

    public List<Campaign> findActiveCampaigns() {
        return campaignRepository.findByActive(true);
    }
}
