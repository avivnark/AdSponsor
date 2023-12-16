package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @GetMapping("/")
    public String HelloWorld(){
        return "Hello AdSponsor";
    }

    @GetMapping("/campaigns/{id}")
    public Campaign GetCampaign(@PathVariable Integer id){
        campaignService.updateCampaignStatus();
        Campaign campaign = campaignService.getCampaign(id);
        if(campaign == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return campaign;
    }

    @DeleteMapping("/campaigns/{id}")
    public void DeleteCampaign(@PathVariable Integer id){
        campaignService.removeCampaign(id);
    }

    @GetMapping("/campaigns")
    public Iterable<Campaign> GetCampaigns(){
        return campaignService.getCampaigns();
    }

    @PostMapping("/campaigns/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaignWithProducts(campaign);
    }



}
