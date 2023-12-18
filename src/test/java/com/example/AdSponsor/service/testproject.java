package com.example.AdSponsor.service;
import com.jayway.jsonpath.JsonPath;
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
import java.util.List;

import static org.springframework.test.util.AssertionErrors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class testproject {

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
    }
    @Test
    public void testCampaignWithMissingId() throws Exception {
        Campaign campaign = new Campaign();
        int length = 10;
        String randomName = RandomStringUtils.randomAlphanumeric(length);
        campaign.setName(randomName);
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(List.of(-1));

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetPromotedProductWithHighestBidByCategory() throws Exception {
        // Add a campaign
        Campaign campaign = new Campaign();
        int length = 10;
        String randomName = RandomStringUtils.randomAlphanumeric(length);
        campaign.setName(randomName);
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(List.of(1));

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isCreated());

        // Fetch the promoted product with the highest bid for the specified category
        mockMvc.perform(MockMvcRequestBuilders.get("/ads/serveAd/{category}", "Electronics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testIfNotGetting() throws Exception {
        // Add a campaign
        Campaign campaign = new Campaign();
        int length = 10;
        String randomName = RandomStringUtils.randomAlphanumeric(length);
        campaign.setName(randomName);
        campaign.setBid(BigDecimal.valueOf(10.0));
        campaign.setStartDate(LocalDate.now());
        campaign.setIds(List.of(1));

        String campaignJson = objectMapper.writeValueAsString(campaign);

        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isCreated());

        // Fetch the promoted product with the highest bid for the specified category
        mockMvc.perform(MockMvcRequestBuilders.get("/ads/serveAd/{category}", randomName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testRightResult() throws Exception {
        // Add campaigns
        Campaign campaign1 = createCampaign("Campaign 1", 15.0, LocalDate.now(), Arrays.asList(1,8));
        Campaign campaign2 = createCampaign("Campaign 2", 101.0, LocalDate.now().minusDays(11), List.of(2));
        Campaign campaign3 = createCampaign("Campaign 3", 1.0, LocalDate.now().minusDays(5), Arrays.asList(2, 3, 5));
        Campaign campaign4 = createCampaign("Campaign 4", 13.0, LocalDate.now().minusDays(5), Arrays.asList(6,7,9));

        // Add campaigns
        addCampaign(campaign1);
        addCampaign(campaign2);
        addCampaign(campaign3);
        addCampaign(campaign4);

        String electronicsIds = checkCategory("Electronics").toString();
        String booksIds = checkCategory("Books").toString();
        String fashionIds = checkCategory("Fashion").toString();
        String healthFitnessIds = checkCategory("Health & Fitness").toString();

        // Define the expected IDs as strings
        String expectedElectronicsIds = List.of(1).toString();
        String expectedBooksIds = List.of(1).toString();
        String expectedFashionIds = List.of(9).toString();
        String expectedHealthFitnessIds = List.of(7).toString();

        // Assert the obtained ID strings with the expected ones
        assertEquals("1:",expectedElectronicsIds, electronicsIds);
        assertEquals("2:",expectedBooksIds, booksIds);
        assertEquals("3:",expectedFashionIds, fashionIds);
        assertEquals("4:",expectedHealthFitnessIds, healthFitnessIds);



    }
    private Campaign createCampaign(String name, double bid, LocalDate startDate, List ids) {
        Campaign campaign = new Campaign();
        campaign.setName(name);
        campaign.setBid(BigDecimal.valueOf(bid));
        campaign.setStartDate(startDate);
        campaign.setIds(ids);
        return campaign;
    }

    private void addCampaign(Campaign campaign) throws Exception {
        String campaignJson = objectMapper.writeValueAsString(campaign);
        mockMvc.perform(MockMvcRequestBuilders.post("/campaigns/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(campaignJson))
                .andExpect(status().isCreated());
    }

    private List<Integer> checkCategory(String category) throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/ads/serveAd/{category}", category)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        return JsonPath.read(content, "$..id");
    }



}
