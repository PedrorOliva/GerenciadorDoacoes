package com.catalisa.GerenciamentoDoacoes.mapper;

import com.catalisa.GerenciamentoDoacoes.dto.DonationDTO;
import com.catalisa.GerenciamentoDoacoes.model.DonationModel;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper {
  public DonationDTO toDonationDTO(DonationModel donationModel) {
    DonationDTO donationDTO = new DonationDTO();


    donationDTO.setValue(donationModel.getValue());
    donationDTO.setDonationDate(donationModel.getDonationDate());
    donationDTO.setPaymentMethod(donationModel.getPaymentMethod());
    donationDTO.setDonor(donationModel.getDonor());
    donationDTO.setCampaign(donationModel.getCampaign());

    return donationDTO;
  }
}
