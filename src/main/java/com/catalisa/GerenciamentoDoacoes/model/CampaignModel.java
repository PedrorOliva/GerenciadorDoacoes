package com.catalisa.GerenciamentoDoacoes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_campaign")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampaignModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome é obrigatório!")
  @Length(min = 3, max = 50, message = "O nome deverá ter no máximo {max} caracteres.")
  private String name;

  @NotBlank(message = "A descrição é obrigatório!")
  @Length(min = 10, max = 255, message = "O nome deverá ter no máximo {max} caracteres.")
  private String description;

  @Column(name = "goal", nullable = false)
  @NotNull(message = "O valor que deseja arrecadar é obrigatório!")
  private BigDecimal goal;

  @Column(name = "amountCollected")
  private BigDecimal amountCollected = BigDecimal.ZERO;

  @NotBlank(message = "A data de início é obrigatório!")
  private String start;

  @NotBlank(message = "A data de término é obrigatório!")
  private String finish;

  @Column(name = "status", nullable = false)
  private String status = "ativa";

}
