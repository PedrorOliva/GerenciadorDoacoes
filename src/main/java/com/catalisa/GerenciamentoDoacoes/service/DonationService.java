package com.catalisa.GerenciamentoDoacoes.service;

import com.catalisa.GerenciamentoDoacoes.dto.DonationDTO;
import com.catalisa.GerenciamentoDoacoes.exceptions.handleIdNotFound;
import com.catalisa.GerenciamentoDoacoes.mapper.DonationMapper;
import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import com.catalisa.GerenciamentoDoacoes.model.DonationModel;
import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import com.catalisa.GerenciamentoDoacoes.repository.CampaignRepository;
import com.catalisa.GerenciamentoDoacoes.repository.DonationRepository;
import com.catalisa.GerenciamentoDoacoes.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService {
  @Autowired
  DonationRepository donationRepository;

  @Autowired
  CampaignRepository campaignRepository;

  @Autowired
  DonorRepository donorRepository;

  @Autowired
  DonationMapper donationMapper;

  public DonationDTO create(DonationModel donationModel) {
    DonorModel donorModel = donorRepository.findById(donationModel.getDonor().getId()).orElse(null);

    if(donationModel == null) {
      throw new handleIdNotFound("Doador não encontrado!");
    }

    donationModel.setDonor(donorModel);

    DonationModel newDonation = donationRepository.save(donationModel);

    CampaignModel campaign = newDonation.getCampaign();

    BigDecimal newAmount = campaign.getAmountCollected().add(newDonation.getValue());
    campaign.setAmountCollected(newAmount);
    campaignRepository.save(campaign);

    return donationMapper.toDonationDTO(donationModel);
  }

  public List<DonationDTO> listAllDonations() {
    List<DonationModel> donationModels = donationRepository.findAll();
    List<DonationDTO> donationDTOS = new ArrayList<>();

    for (DonationModel donationModel : donationModels) {
      donationDTOS.add(donationMapper.toDonationDTO(donationModel));
    }
    return donationDTOS;
  }

  public Optional<DonationDTO> findDonationById(Long id) {
    Optional<DonationModel> donationModelOptional = donationRepository.findById(id);

    if (donationModelOptional.isEmpty()) {
      throw new handleIdNotFound("Id não encontrado!");
    }

    DonationModel donation = donationModelOptional.get();
    DonationDTO donationDTO = donationMapper.toDonationDTO(donation);

    return Optional.of(donationDTO);
  }
}
