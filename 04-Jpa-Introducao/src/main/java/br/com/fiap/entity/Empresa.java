package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_EMPRESA")
@SequenceGenerator(sequenceName = "SQ_T_EMPRESA", name="empresa", allocationSize = 1)
public class Empresa {

	@Id
	@Column(name="cd_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	private Integer codigo;
	
	@Column(name="nm_empresa", nullable = false, length = 20)
	private String nome;
	
	@Column(name="nr_cnpj", nullable = false, length = 14)
	private String cnpj;
	
	@Temporal(TemporalType.DATE) //Somente a data
	@Column(name="dt_fundacao", nullable = false)
	private Calendar dataFundacao;
	
	@Column(name="nr_funcionario", precision = 5)
	private Integer numeroFuncionarios;
	
	@Transient
	private Integer anosFuncionamento;
	
	@Column(name="ds_email", length = 50, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_status", length = 10)
	private StatusEmpresa status;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Column(name="vl_faturamento", precision = 10, scale = 2)
	private Double faturamento;
	
	@Column(name="ds_estatal")
	private Boolean estatal;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getAnosFuncionamento() {
		return anosFuncionamento;
	}

	public void setAnosFuncionamento(Integer anosFuncionamento) {
		this.anosFuncionamento = anosFuncionamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusEmpresa getStatus() {
		return status;
	}

	public void setStatus(StatusEmpresa status) {
		this.status = status;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}

	public Boolean getEstatal() {
		return estatal;
	}

	public void setEstatal(Boolean estatal) {
		this.estatal = estatal;
	}
	
}
