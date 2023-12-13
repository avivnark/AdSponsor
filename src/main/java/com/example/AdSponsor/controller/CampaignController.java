package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
public class CampaignController {

    private Map<String, Campaign> dbCampaign = new HashMap<>();

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello AdSponsor";
    }

    @GetMapping("/campaigns")
    public Collection<Campaign> GetCampaigns(){
        return dbCampaign.values();
    }

    @PostMapping("/campaign/")
    public Campaign CreateCampaign(@RequestBody Campaign campaign){
        campaign.setId(UUID.randomUUID().toString());
        dbCampaign.put(campaign.getId(), campaign);
        return campaign;
    }


}
