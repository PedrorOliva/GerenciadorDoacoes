package com.catalisa.GerenciamentoDoacoes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_donation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonationModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "value", nullable = false)
  @NotNull(message = "O valor é obrigatório!")
  private BigDecimal value;

  @NotBlank(message = "A data é obrigatória!!")
  private String  donationDate;

  @NotBlank(message = "O método de pagamento é obrigatório!")
  private String paymentMethod;

  @ManyToOne
  @JoinColumn(name = "donor_id")
  private DonorModel donor;

  @ManyToOne
  @JoinColumn(name = "campaign_id")
  private CampaignModel campaign;
}
