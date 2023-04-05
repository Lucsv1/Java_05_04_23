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
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="T_USUARIO")
//sequenceName -> nome da sq no Banco, name-> usado generator, allocationSize -> incremento 
@SequenceGenerator(sequenceName = "SQ_T_USUARIO", name="churros", allocationSize = 1)
public class Usuario {

	@Id	
	@Column(name="cd_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "churros")
	private int codigo;
	
	@Column(name="nm_usuario", nullable = false, length = 30)
	private String nome;
	
	@Column(name="vl_senha", nullable = false, length = 20)
	private String senha;
	
	@CreationTimestamp //Cria a data de cadastro automaticamente
	@Temporal(TemporalType.TIMESTAMP) //Grava data e hora no banco
	@Column(name="dt_criacao", nullable = false, updatable = false)
	private Calendar dataCriacao;
	
	@Column(name="nr_cpf", length = 11, updatable = false)
	private String cpf;
	
	@Column(name="ds_email", nullable = false, length = 30)
	private String email;
	
	@Column(name="vl_altura", precision = 3 , scale = 2)
	private Float altura;
	
	@Transient //Nï¿½o serï¿½ uma coluna na tabela
	private String token;
	
	@Lob //Mapeia um campo do tipo BLOB, que recebe arquivos (foto)
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)//Grava o texto da constante e nÃ£o a posicao
	@Column(name="ds_tipo", length = 20)
	private TipoUsuario tipo;
	
	public Usuario() {}
	
	public Usuario(String nome, String senha, String cpf,
			String email, Float altura, TipoUsuario tipo) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.email = email;
		this.altura = altura;
		this.tipo = tipo;
	}
	
	@PrePersist //Antes de cadastrar
	@PostUpdate //Após atualizar
	@PostLoad //Executa apos um select
	private void executar() {
		System.out.println("Executando um comando SQL");
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
}



