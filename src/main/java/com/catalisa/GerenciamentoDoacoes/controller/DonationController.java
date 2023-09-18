package com.catalisa.GerenciamentoDoacoes.controller;

import com.catalisa.GerenciamentoDoacoes.dto.DonationDTO;
import com.catalisa.GerenciamentoDoacoes.model.DonationModel;
import com.catalisa.GerenciamentoDoacoes.service.DonationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/donation")
@Tag(name = "Doações")
public class DonationController {
  @Autowired
  DonationService donationService;

  @Operation(summary = "Essa rota permite cadastrar uma nova doação, passando as informações pelo body da " +
      "requisição, é necessário que a informação no body contenha o ID da campanha e o ID do doador.",
      method =
      "POST")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Criado com sucesso"))
  @PostMapping
  public ResponseEntity<?> createDonation(@Valid @RequestBody DonationModel donationModel) {
    return new ResponseEntity<>(donationService.create(donationModel), HttpStatus.CREATED);
  }

  @Operation(summary = "Essa rota busca todas as doações.", method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping
  public ResponseEntity<List<DonationDTO>> findAllDonations() {
    return new ResponseEntity<>(donationService.listAllDonations(), HttpStatus.OK);
  }

  @Operation(summary = "Essa rota permite buscar uma doação pelo ID, bastando passar o valor na url.",
      method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping(path = "/{id}")
  public ResponseEntity<Optional<DonationDTO>> findDonationId(@PathVariable Long id) {
    return new ResponseEntity<>(donationService.findDonationById(id), HttpStatus.OK);
  }
}
