package br.com.sucatabusiness.exceptions;

public class NegocioException extends RuntimeException {

	public NegocioException(String mensagem) {
		super(mensagem);
	}
}
