package com.example.AdSponsor.repository;
import com.example.AdSponsor.model.Campaign;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
    Campaign findByName(String testCampaign);
}
