package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@RestController
public class CampaignController {

    private final CampaignService CampaignService;

    public CampaignController(@Autowired CampaignService campaignService) {
        CampaignService = campaignService;
    }


    @GetMapping("/")
    public String HelloWorld(){
        return "Hello AdSponsor";
    }

    @GetMapping("/campaigns/{id}")
    public Campaign GetCampaign(@PathVariable String id){
        Campaign campaign = CampaignService.get(id);
        if(campaign == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return campaign;
    }

    @DeleteMapping("/campaigns/{id}")
    public void DeleteCampaign(@PathVariable String id){
        Campaign campaign = CampaignService.remove(id);
        if(campaign == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/campaigns")
    public Collection<Campaign> GetCampaigns(){
        return CampaignService.get().values();
    }

    @PostMapping("/campaign/")
    public Campaign CreateCampaign(@RequestBody Campaign campaign){
        //Campaign campaign = new Campaign();
        campaign.setId(UUID.randomUUID().toString());
        CampaignService.get().put(campaign.getId(), campaign);
        //CampaignService.set()
        return campaign;
    }



}
