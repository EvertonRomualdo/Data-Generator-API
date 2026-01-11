package br.com.everton.datageneratorapi.repository;

import br.com.everton.datageneratorapi.models.Cpf;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic repository with additional functions for CPF entity.
 */
public interface CpfRepository extends JpaRepository<Cpf, UUID> {

  /**
   * Find by cpf number.
   *
   * @param cpf The cpf.
   * @return One optional object.
   */
  Optional<Cpf> findByCpf(String cpf);

  /**
   * Return true if cpf already exist.
   *
   * @param cpf The cpf number.
   * @return Boolean value.
   */
  boolean existsCpfByCpf(String cpf);
}
