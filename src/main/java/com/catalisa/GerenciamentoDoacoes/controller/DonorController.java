package com.catalisa.GerenciamentoDoacoes.controller;

import com.catalisa.GerenciamentoDoacoes.dto.DonorDTO;
import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import com.catalisa.GerenciamentoDoacoes.service.DonorService;
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
@RequestMapping("api/donor")
@Tag(name = "Doadores")
public class DonorController {
  @Autowired
  DonorService donorService;

  @Operation(summary = "Essa rota permite cadastrar um doador, passando nome e email no corpo da requisição",
      method = "POST")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Cadastrado com sucesso!"))
  @PostMapping
  public ResponseEntity<?> registerDonor(@Valid @RequestBody DonorModel donorModel) {
    DonorDTO newDonor = donorService.register(donorModel);
    return new ResponseEntity<>(newDonor, HttpStatus.CREATED);
  }

  @Operation(summary = "Essa rota busca todos os doadores cadastrados.", method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping
  public ResponseEntity<List<DonorDTO>> findAllDonors() {
    return ResponseEntity.ok(donorService.findAllDonor());
  }

  @Operation(summary = "Essa rota permite buscar um doador pelo ID, bastando passar o valor na url.",
      method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping(path = "/{id}")
  public ResponseEntity<Optional<DonorDTO>> findOneDonor(@PathVariable Long id) {
    return ResponseEntity.ok(donorService.findById(id));
  }

  @Operation(summary = "Essa rota permite buscar um doador pelo nome, bastando passar o nome como " +
      "parametro na url.", method = "GET")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @GetMapping(path = "/donorName")
  public ResponseEntity<Optional<DonorDTO>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(donorService.findByName(name));
  }

  @Operation(summary = "Essa rota permite atualizar uma informação do doador", method = "PUT")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Informação atualizada com sucesso"))
  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updateDonor(@PathVariable Long id, @RequestBody DonorDTO donorDTO) {
    return ResponseEntity.ok(donorService.updateDonor(id, donorDTO));
  }

  @Operation(summary = "Essa rota permite deletar um doador, basta apenas informar o ID do produto na url.",
      method = "DELETE")
  @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
  @DeleteMapping(path = "/{id}")
  public void deleteDonor(@PathVariable Long id) {
    donorService.deleteDonor(id);
  }
}
