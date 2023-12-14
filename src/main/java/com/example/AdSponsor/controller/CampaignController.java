package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class CampaignController {

    private final CampaignService CampaignService;

    public CampaignController(CampaignService campaignService) {
        this.CampaignService = campaignService;
    }


    @GetMapping("/")
    public String HelloWorld(){
        return "Hello AdSponsor";
    }

    @GetMapping("/campaigns/{id}")
    public Campaign GetCampaign(@PathVariable Integer id){
        Campaign campaign = CampaignService.getCampaign(id);
        if(campaign == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return campaign;
    }

    @DeleteMapping("/campaigns/{id}")
    public void DeleteCampaign(@PathVariable Integer id){
        CampaignService.removeCampaign(id);
    }

    @GetMapping("/campaigns")
    public Iterable<Campaign> GetCampaigns(){
        return CampaignService.getCampaigns();
    }

    @PostMapping("/campaign/")
    public Campaign CreateCampaign(@RequestBody Campaign campaign){
        //Campaign campaign = new Campaign();
        //CampaignService.add()
        return campaign;
    }



}
