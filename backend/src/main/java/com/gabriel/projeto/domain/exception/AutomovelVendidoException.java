package com.gabriel.projeto.domain.exception;

public class AutomovelVendidoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AutomovelVendidoException(String mensagem) {
		super(mensagem);
	}
}
