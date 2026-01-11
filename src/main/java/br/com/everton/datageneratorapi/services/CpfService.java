package br.com.everton.datageneratorapi.services;

import br.com.everton.datageneratorapi.dto.CpfResponseDto;
import br.com.everton.datageneratorapi.repository.CpfRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Cpf service with operation about CPFs.
 */
public interface CpfService {

  /**
   * Creates a CPF number based on the parameters passed.
   *
   * @return A CPFResponseDto containing the generated number
   */
  CpfResponseDto generateCpf();

  /**
   * Get exist CPF.
   *
   * @param id the cpf id.
   * @return The cpf number.
   */
  CpfResponseDto getCpf(UUID id);

}
