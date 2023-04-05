package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_LIVRO")
@SequenceGenerator(name="livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro {

	@Id
	@Column(name="cd_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Integer codigo;
	
	@Column(name="ds_titulo", nullable = false, length = 50)
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private Genero genero;
	
	@Column(name="nr_pagina", precision = 4)
	private Integer quantidadePaginas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	public Livro() {}

	public Livro(String titulo, Genero genero, Integer quantidadePaginas, Calendar dataLancamento) {
		this.titulo = titulo;
		this.genero = genero;
		this.quantidadePaginas = quantidadePaginas;
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
}