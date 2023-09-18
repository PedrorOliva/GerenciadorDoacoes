package com.catalisa.GerenciamentoDoacoes.dto;

import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonationDTO {
  private BigDecimal value;
  private String donationDate;
  private String paymentMethod;
  private DonorModel donor;
  private CampaignModel campaign;
}
