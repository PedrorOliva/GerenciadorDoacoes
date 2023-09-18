package com.catalisa.GerenciamentoDoacoes.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_donor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonorModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome é obrigatório!!")
  @Length(min = 3, max = 50, message = "O nome deverá ter no máximo {max} caracteres.")
  private String name;

  @NotBlank(message = "O email é obrigatório!")
  @Email(message = "Informe um email válido!")
  @Length(max = 50, message = "O email dever ter no máximo {max} caracteres.")
  private String email;

}
