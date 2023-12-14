package com.example.AdSponsor.service;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    private Map<String, Campaign> dbCampaign = new HashMap<>();


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

    public Map<String, Campaign> get() {
        return dbCampaign;
    }

    public Campaign get(String id) {
        return dbCampaign.get(id);
    }

    public Campaign remove(String id) {
        return dbCampaign.remove(id);
    }
}
