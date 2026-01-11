package br.com.everton.datageneratorapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

/**
 * Represents a CPF and its metadata.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cpf")
public class Cpf {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Column(unique = true,  nullable = false,  length = 11, name = "cpf")
  private String cpf;
  @NotBlank
  @Column(unique = true, nullable = true, length = 2, name = "cpf_check_digits")
  private String cpfCheckDigits;

  @NotNull
  @Column(nullable = false, name = "is_valid")
  private Boolean isValid;

}
