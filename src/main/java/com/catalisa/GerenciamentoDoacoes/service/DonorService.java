package com.catalisa.GerenciamentoDoacoes.service;

import com.catalisa.GerenciamentoDoacoes.dto.DonorDTO;
import com.catalisa.GerenciamentoDoacoes.exceptions.handleIdNotFound;
import com.catalisa.GerenciamentoDoacoes.exceptions.handleNameNotFound;
import com.catalisa.GerenciamentoDoacoes.mapper.DonorMapper;
import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import com.catalisa.GerenciamentoDoacoes.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

  @Autowired
  DonorRepository donorRepository;

  @Autowired
  DonorMapper donorMapper;

  public DonorDTO register(DonorModel donorModel) {
    donorRepository.save(donorModel);
    return donorMapper.toDonorDTO(donorModel);
  }

  public List<DonorDTO> findAllDonor() {
    List<DonorModel> donorModels = donorRepository.findAll();
    List<DonorDTO> donorDTOS = new ArrayList<>();

    for (DonorModel donorModel : donorModels) {
      donorDTOS.add(donorMapper.toDonorDTO(donorModel));
    }
    return donorDTOS;
  }

  public Optional<DonorDTO> findById(Long id) {
    Optional<DonorModel> donorModelOptional = donorRepository.findById(id);

    if (donorModelOptional.isEmpty()) {
      throw new handleIdNotFound("Id não encontrado!");
    }

    DonorModel donor = donorModelOptional.get();
    DonorDTO donorDTO = donorMapper.toDonorDTO(donor);
    return Optional.of(donorDTO);
  }

  public Optional<DonorDTO> findByName(String name) {
    Optional<DonorModel> donorModelOptional = donorRepository.findByName(name);

    if (donorModelOptional.isEmpty()) {
      throw new handleNameNotFound("Nome não encontrado!");
    }

    DonorModel donor = donorModelOptional.get();
    DonorDTO donorDTO = donorMapper.toDonorDTO(donor);
    return Optional.of(donorDTO);
  }

  public Optional<DonorModel> findByEmail(String email) {
    return donorRepository.findByEmail(email);
  }

  public DonorDTO updateDonor(Long id, DonorDTO donorDTO) {
    Optional<DonorModel> donorOptional = donorRepository.findById(id);

    if (donorOptional.isEmpty()) {
      throw new handleIdNotFound("Id não encontrado!");
    }

    DonorModel donor = donorOptional.get();
    if (donorDTO.getName() != null) {
      donor.setName(donorDTO.getName());
    }
    if (donorDTO.getEmail() != null) {
      donor.setEmail(donorDTO.getEmail());
    }
    donorRepository.save(donor);
    return donorMapper.toDonorDTO(donor);
  }

  public void deleteDonor(Long id) {
    donorRepository.deleteById(id);
  }
}
