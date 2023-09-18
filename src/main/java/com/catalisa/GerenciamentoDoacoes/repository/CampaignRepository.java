package com.catalisa.GerenciamentoDoacoes.repository;

import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import com.catalisa.GerenciamentoDoacoes.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignModel, Long> {
  Optional<CampaignModel> findByName(String name);
}
