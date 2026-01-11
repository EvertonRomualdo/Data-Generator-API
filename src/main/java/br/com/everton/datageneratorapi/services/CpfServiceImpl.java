package br.com.everton.datageneratorapi.services;

import br.com.everton.datageneratorapi.exception.CpfExistException;
import br.com.everton.datageneratorapi.dto.CpfResponseDto;
import br.com.everton.datageneratorapi.exception.CpfNotFoundException;
import br.com.everton.datageneratorapi.models.Cpf;
import br.com.everton.datageneratorapi.repository.CpfRepository;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of CpfService interface.
 */
@Service
@AllArgsConstructor
public class CpfServiceImpl implements CpfService {

  private CpfRepository cpfRepository;
  private Random random;

  @Override
  @Transactional
  public CpfResponseDto generateCpf() {

    String cpfNumber = createCpf();
    if (cpfRepository.existsCpfByCpf(cpfNumber)) {

      throw new CpfExistException();
    }


    String checkDigits = cpfNumber.substring(cpfNumber.length() - 2);
    Cpf cpf = new Cpf();
    cpf.setCpf(cpfNumber);
    cpf.setCpfCheckDigits(checkDigits);
    cpf.setIsValid(true);
    Cpf savedCpf = cpfRepository.save(cpf);

    return new  CpfResponseDto(savedCpf.getId(), savedCpf.getCpf());
  }

  @Override
  public CpfResponseDto getCpf(UUID id) {

    Cpf cpf = cpfRepository.findById(id).orElseThrow(CpfNotFoundException::new);

    return new CpfResponseDto(cpf.getId(), cpf.getCpf());
  }

  private String createCpf() {

    String randomNumber = String.valueOf(random.nextInt(100_000_000, 1_000_000_000));
    return generateCheckDigits(randomNumber);

  }

  private String generateCheckDigits(String baseCpf) {

    int firstDigit = calculateCheckDigit(baseCpf, 10);
    int secondDigit = calculateCheckDigit(baseCpf + firstDigit, 11);

    return baseCpf + firstDigit + secondDigit;
  }

  private int calculateCheckDigit(String cpf, int weightStart) {

    int sum = 0;
    int weight = weightStart;

    for (int i = 0; i < cpf.length(); i++) {
      int digit = cpf.charAt(i) - '0';
      sum += digit * weight--;
    }

    return getCheckDigit(sum);
  }

  private int getCheckDigit(int sum) {

    int checkDigitMod = sum % 11;
    if (checkDigitMod < 2) {
      return 0;
    } else {
      return 11 - checkDigitMod;
    }

  }
}
