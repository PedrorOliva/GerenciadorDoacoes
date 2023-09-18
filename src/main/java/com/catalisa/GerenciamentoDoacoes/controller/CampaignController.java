package com.catalisa.GerenciamentoDoacoes.controller;

import com.catalisa.GerenciamentoDoacoes.dto.CampaignDTO;
import com.catalisa.GerenciamentoDoacoes.model.CampaignModel;
import com.catalisa.GerenciamentoDoacoes.service.CampaignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/campaign")
@Tag(name = "Campanhas")
public class CampaignController {
  @Autowired
  CampaignService campaignService;

  @Operation(summary = "Essa rota permite cadastrar uma campanha, passando as informações no corpo da " +
      "requisição, é obrigatório nome, descrição, valor alvo, data de início e data de finalização", method =
      "POST")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Criado com sucesso"))
  @PostMapping
  public ResponseEntity<?> registerCampaign(@Valid @RequestBody CampaignModel campaignModel) {
    CampaignDTO newCampaign = campaignService.register(campaignModel);
    return ResponseEntity.ok(newCampaign);
  }

  @Operation(summary = "Essa rota busca todas as campanhas que foram cadastradas.", method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping
  public ResponseEntity<List<CampaignDTO>> findAllCampaigns(){
    return ResponseEntity.ok(campaignService.listAllCampaigns());
  }

  @Operation(summary = "Essa rota permite buscar uma campanha específica pelo ID, bastando passar o valor " +
      "na url.",
      method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping(path = "/{id}")
  public ResponseEntity<Optional<CampaignDTO>> findCampaignById(@PathVariable Long id) {
    return ResponseEntity.ok(campaignService.listCampaignById(id));
  }

  @Operation(summary = "Essa rota permite buscar uma campanha pelo nome, bastando passar o nome como " +
      "parametro na url.", method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping(path = "/searchCampaign")
  public ResponseEntity<Optional<CampaignDTO>> findCampignByName(@RequestParam String name) {
    return ResponseEntity.ok(campaignService.listCampaignByName(name));
  }

  @Operation(summary = "Essa rota permite atualizar as informações de uma campanha", method = "PUT")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Informação atualizada com sucesso"))
  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updateCampaign(@PathVariable Long id, @RequestBody CampaignDTO campaignDTO) {
    return ResponseEntity.ok(campaignService.updateCampaign(id, campaignDTO));
  }

  @Operation(summary = "Essa rota permite deletar uma campanha, basta apenas informar o ID do produto na " +
      "url.",
      method = "DELETE")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @DeleteMapping(path = "/{id}")
  public void deleteCampaign(@PathVariable Long id) {
    campaignService.deleteCampaign(id);
  }
}
