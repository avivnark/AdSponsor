package com.example.AdSponsor.controller;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.service.CampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

>>>>>>> 0b7d5b4 (sql)

@RestController
public class CampaignController {

<<<<<<< HEAD
    private final CampaignService CampaignService;

    public CampaignController(CampaignService campaignService) {
        this.CampaignService = campaignService;
=======
    private final CampaignService campaignService;


    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
>>>>>>> 0b7d5b4 (sql)
    }


    @GetMapping("/")
    public String HelloWorld(){
        return "Hello AdSponsor";
    }

    @GetMapping("/campaigns/{id}")
    public Campaign GetCampaign(@PathVariable Integer id){
<<<<<<< HEAD
        Campaign campaign = CampaignService.getCampaign(id);
=======
        Campaign campaign = campaignService.getCampaign(id);
>>>>>>> 0b7d5b4 (sql)
        if(campaign == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return campaign;
    }

    @DeleteMapping("/campaigns/{id}")
    public void DeleteCampaign(@PathVariable Integer id){
<<<<<<< HEAD
        CampaignService.removeCampaign(id);
=======
        campaignService.removeCampaign(id);
>>>>>>> 0b7d5b4 (sql)
    }

    @GetMapping("/campaigns")
    public Iterable<Campaign> GetCampaigns(){
<<<<<<< HEAD
        return CampaignService.getCampaigns();
    }

    @PostMapping("/campaign/")
    public Campaign CreateCampaign(@RequestBody Campaign campaign){
        //Campaign campaign = new Campaign();
        //CampaignService.add()
        return campaign;
=======
        return campaignService.getCampaigns();
    }

    /*@PostMapping("/campaigns/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }*/

    @PostMapping("/campaigns/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Campaign createCampaign(@RequestParam String name, @RequestParam LocalDate startDate, @RequestParam List<Integer> productIds, @RequestParam BigDecimal bid) {
        Campaign campaign = new Campaign(name, startDate, productIds, bid);
        return campaignService.createCampaignWithProducts(campaign, campaign.getIds());
>>>>>>> 0b7d5b4 (sql)
    }



<<<<<<< HEAD
=======






>>>>>>> 0b7d5b4 (sql)
}
