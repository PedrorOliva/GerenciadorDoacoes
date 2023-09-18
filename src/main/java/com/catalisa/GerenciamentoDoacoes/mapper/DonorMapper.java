package com.catalisa.GerenciamentoDoacoes.mapper;

import com.catalisa.GerenciamentoDoacoes.dto.DonorDTO;
import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import org.springframework.stereotype.Component;

@Component
public class DonorMapper {
  public DonorDTO toDonorDTO(DonorModel donorModel) {
    DonorDTO donorDTO = new DonorDTO();

    donorDTO.setName(donorModel.getName());
    donorDTO.setEmail(donorModel.getEmail());

    return donorDTO;
  }
}
