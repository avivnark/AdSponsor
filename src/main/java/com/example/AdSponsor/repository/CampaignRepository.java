package com.example.AdSponsor.repository;
import com.example.AdSponsor.model.Campaign;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, String> {
    List<Campaign> findByActive(@Param("active") Boolean active);
    List<Campaign> findByProducts(@Param("productIds") List<String> productIds);
    List<Campaign> findByNameContaining(@Param("name") String name);
    @Query(value = "SELECT c FROM Campaign c WHERE c.startDate BETWEEN :startDateFrom AND :startDateTo")
    List<Campaign> findByStartDateRange(@Param("startDateFrom") Date startDateFrom, @Param("startDateTo") Date startDateTo);
    // Bonus: Search by name (using named parameter)
    @Query(value = "SELECT c FROM Campaign c WHERE c.name LIKE :name")
    List<Campaign> findByNameLike(@Param("name") String name);
    // implement/remove methods in the future
}

