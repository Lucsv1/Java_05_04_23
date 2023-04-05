package br.com.fiap.model;

import java.util.Calendar;

public class Pessoa {

	//Modificadores de acesso:
	//private: somente a classe
	//default/package: pacote
	//protected: pacote e classes filhas
	//public: todos
	private String nome;
	
	private Genero genero;
	
	private Calendar dataNascimento;
	
	//Classes: tipo de referência (padrão null)
	//Primitivo: char, boolean (false) 
	//byte, short, int, long, float, double (padrão 0)
	private int idade;
	
	//Métodos
	public void descansar() {
		System.out.println("Uma pessoa descansa");
	}
	
	//Construtor
	public Pessoa(String nome, Calendar dataNascimento, Genero genero) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}