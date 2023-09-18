package com.catalisa.GerenciamentoDoacoes.service;

import com.catalisa.GerenciamentoDoacoes.dto.CampaignDTO;
import com.catalisa.GerenciamentoDoacoes.exceptions.handleIdNotFound;
import com.catalisa.GerenciamentoDoacoes.exceptions.handleNameNotFound;
import com.catalisa.GerenciamentoDoacoes.mapper.CampaignMapper;
import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import com.catalisa.GerenciamentoDoacoes.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
  @Autowired
  CampaignRepository campaignRepository;

  @Autowired
  CampaignMapper campaignMapper;

  public CampaignDTO register(CampaignModel campaignModel) {
    campaignRepository.save(campaignModel);
    CampaignDTO campaignDTO = campaignMapper.toCampaignDTO(campaignModel);
    return campaignDTO;
  }

  public List<CampaignDTO> listAllCampaigns() {
    List<CampaignModel> campaignModels = campaignRepository.findAll();
    List<CampaignDTO> campaignDTOS = new ArrayList<>();

    for (CampaignModel campaignModel : campaignModels) {
      campaignDTOS.add(campaignMapper.toCampaignDTO(campaignModel));
    }
    return campaignDTOS;
  }

  public Optional<CampaignDTO> listCampaignById(Long id) {
    Optional<CampaignModel> campaignModelOptional = campaignRepository.findById(id);

    if (campaignModelOptional.isEmpty()) {
      throw new handleIdNotFound("Id não encontrado!");
    }

    CampaignModel campaign = campaignModelOptional.get();
    CampaignDTO campaignDTO = campaignMapper.toCampaignDTO(campaign);
    return Optional.of(campaignDTO);
  }

  public Optional<CampaignDTO> listCampaignByName(String name) {
    Optional<CampaignModel> campaignModelOptional = campaignRepository.findByName(name);

    if (campaignModelOptional.isEmpty()) {
      throw new handleNameNotFound("Nome não encontrado!");
    }

    CampaignModel campaign = campaignModelOptional.get();
    CampaignDTO campaignDTO = campaignMapper.toCampaignDTO(campaign);

    return Optional.of(campaignDTO);
  }

  public CampaignDTO updateCampaign(Long id, CampaignDTO campaignDTO) {
    Optional<CampaignModel> campaignModelOptional = campaignRepository.findById(id);

    if(campaignModelOptional.isEmpty()) {
      throw new handleIdNotFound("Id não encontrado!");
    }

    CampaignModel campaign = campaignModelOptional.get();

    if(campaignDTO.getName() != null) {
      campaign.setName(campaignDTO.getName());
    }
    if(campaignDTO.getDescription() != null) {
      campaign.setDescription(campaignDTO.getDescription());
    }
    if(campaignDTO.getGoal() != null) {
      campaign.setGoal(campaignDTO.getGoal());
    }
    if(campaignDTO.getStart() != null) {
      campaign.setStart(campaignDTO.getStart());
    }
    if(campaignDTO.getFinish() != null) {
      campaign.setFinish(campaignDTO.getFinish());
    }
    if(campaignDTO.getStatus() != null) {
      campaign.setStatus(campaignDTO.getStatus());
    }
    campaignRepository.save(campaign);
    return campaignMapper.toCampaignDTO(campaign);
  }

  public void deleteCampaign(Long id) {
    campaignRepository.deleteById(id);
  }

}
