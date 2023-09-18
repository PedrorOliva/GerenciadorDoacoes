package com.catalisa.GerenciamentoDoacoes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampaignDTO {
  private String name;
  private String description;
  private BigDecimal goal;
  private BigDecimal amountCollected;
  private String start;
  private String finish;
  private String status;
}
