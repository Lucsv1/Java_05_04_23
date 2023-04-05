package br.com.fiap.dao;

import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

public interface UsuarioDao {

	//CRUD
	void cadastrar(Usuario usuario);
	
	Usuario pesquisar(int id) throws EntidadeNaoEncontradaException;
	
	void atualizar(Usuario usuario) throws EntidadeNaoEncontradaException;
	
	void deletar(int id) throws EntidadeNaoEncontradaException;
	
	void commit() throws CommitException;
	 
}