package br.com.everton.datageneratorapi.controller;

import br.com.everton.datageneratorapi.dto.CpfResponseDto;
import br.com.everton.datageneratorapi.services.CpfService;
import br.com.everton.datageneratorapi.services.CpfServiceImpl;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of CPF.
 */
@RestController
@RequestMapping("/generate/cpf")
@AllArgsConstructor
public class Controller {

  private CpfService cpfService;

  /**
   * Post endpoint.
   *
   * @return cpfNumber.
   */
  @PostMapping
  public ResponseEntity<CpfResponseDto> generateCpf() {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(cpfService.generateCpf());
  }

  /**
   * Get endpoint.
   *
   * @param id cpf id in the database.
   * @return cpfNumber.
   */
  @GetMapping("{id}")
  public ResponseEntity<CpfResponseDto> getCpf(@PathVariable UUID id) {

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(cpfService.getCpf(id));
  }
}
