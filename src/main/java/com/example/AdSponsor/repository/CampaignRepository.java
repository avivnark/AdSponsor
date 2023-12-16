package com.example.AdSponsor.repository;

import com.example.AdSponsor.model.Campaign;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {

}
