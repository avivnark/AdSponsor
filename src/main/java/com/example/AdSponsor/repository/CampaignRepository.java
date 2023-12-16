package com.example.AdSponsor.repository;

import com.example.AdSponsor.model.Campaign;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
}
