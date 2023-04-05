package br.com.fiap.model;

import java.util.Calendar;

public class Aluno extends Pessoa {

	//Sobrecarga: métodos com o mesmo nome, mas parametros diferentes
	public Aluno(String nome) {
		super(nome);
	}
	
	public Aluno(String nome, Calendar dataNascimento, Genero genero) {
		super(nome, dataNascimento, genero);
	}
	
	public Aluno(String nome, int idade) {
		super(nome, idade);
	}
	
	//Sobrescrita de método: método do pai implementada na filha
	public void descansar() {
		System.out.println("Aluno estuda");
		super.descansar();
	}
	
}