package br.com.everton.datageneratorapi.exception;

/**
 * It indicates that the CPF already exists.
 */
public class CpfExistException extends RuntimeException {

  /**
   * Constructor Exception.
   */
  public CpfExistException() {
    super("The CPF already exists in the database");
  }
}
