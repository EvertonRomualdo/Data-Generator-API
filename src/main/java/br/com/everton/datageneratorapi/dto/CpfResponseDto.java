package br.com.everton.datageneratorapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Basic response DTO.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CpfResponseDto {

  @NotNull
  private UUID id;

  @NotBlank
  private String cpf;
}
