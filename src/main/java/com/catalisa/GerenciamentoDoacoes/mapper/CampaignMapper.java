package com.catalisa.GerenciamentoDoacoes.mapper;

import com.catalisa.GerenciamentoDoacoes.dto.CampaignDTO;
import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {
  public CampaignDTO toCampaignDTO(CampaignModel campaignModel) {
    CampaignDTO campaignDTO = new CampaignDTO();

    campaignDTO.setName(campaignModel.getName());
    campaignDTO.setDescription(campaignModel.getDescription());
    campaignDTO.setGoal(campaignModel.getGoal());
    campaignDTO.setStart(campaignModel.getStart());
    campaignDTO.setFinish(campaignModel.getFinish());
    campaignDTO.setStatus(campaignModel.getStatus());

    return campaignDTO;
  }
}
