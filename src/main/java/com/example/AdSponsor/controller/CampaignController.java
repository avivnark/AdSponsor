package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CampaignController {

    private Map<String, Campaign> db = new HashMap<>();

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping("/campaigns")
    public Collection<Campaign> get(){
        return db.values();
    }

    @PostMapping("/campaign/")
    public Campaign create(Campaign campaign){
        campaign.setId(UUID.randomUUID().toString());
        db.put(campaign.getId(), campaign);
        return campaign;
    }


}
