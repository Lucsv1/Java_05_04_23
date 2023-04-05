package br.com.fiap.jpa.exception;

public class EntidadeNaoEcontradaException extends Exception {
	
	public EntidadeNaoEcontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEcontradaException(String msg) {
		super(msg);
	}

}
