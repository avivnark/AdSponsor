package com.example.AdSponsor.service;
import org.apache.commons.lang3.RandomStringUtils;

import com.example.AdSponsor.model.Campaign;
import com.example.AdSponsor.repository.CampaignRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.util.AssertionErrors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class Tests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void testAddCampaign() throws Exception {
        Campaign campaign = new Campaign();
        int length = 10;
        String randomName = RandomStringUtils.randomAlphanumeric(length);
        campaign.setName(randomName);
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(Arrays.asList(1, 2, 3)); // Set some IDs as an example

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
        // Retrieve the created campaign from the repository
        Campaign addedCampaign = campaignRepository.findByName(randomName);
        // Assert that the retrieved campaign matches the expected values
        assertEquals("name ok",randomName, addedCampaign.getName());

    }
    @Test
    public void testAddCampaignNameMissing() throws Exception {
        Campaign campaign = new Campaign();
        // campaign.setName("Test Campaign"); // Omitting setting the name intentionally
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(Arrays.asList(1, 2, 3)); // Set some IDs as an example

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isBadRequest()); // Assuming a bad request will be triggered due to missing name

        // Ensure that there's no campaign added
        Campaign addedCampaign = campaignRepository.findByName("Test Campaign");
        assertNull("Campaign shouldn't be added with missing name", addedCampaign);
    }
    @Test
    public void testCampaignWithMissingId() throws Exception {
        Campaign campaign = new Campaign();
        int length = 10;
        String randomName = RandomStringUtils.randomAlphanumeric(length);
        campaign.setName(randomName);
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(Arrays.asList(-1));

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isBadRequest());
    }




}
