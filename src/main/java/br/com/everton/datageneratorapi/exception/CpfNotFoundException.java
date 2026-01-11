package br.com.everton.datageneratorapi.exception;

/**
 * Cpf not Foud exception.
 */
public class CpfNotFoundException extends RuntimeException {

  /**
   * Exception constructor.
   */
  public CpfNotFoundException() {
    super("CPF not found.");
  }
}
