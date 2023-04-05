package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

public class UsuarioDaoImpl implements UsuarioDao {

	private EntityManager em;

	// construtor que recebe o em
	public UsuarioDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usuario) {
		em.persist(usuario);
	}

	public Usuario pesquisar(int id) throws EntidadeNaoEncontradaException {
		Usuario usuario = em.find(Usuario.class, id);
		// Verificar se o usuario existe 
		if (usuario == null)
			throw new EntidadeNaoEncontradaException("Usuario não encontrado");
		return usuario;
	}

	public void atualizar(Usuario usuario) throws EntidadeNaoEncontradaException {
		//Verificar se o usuario existe para ser atualizado
		pesquisar(usuario.getCodigo());
		em.merge(usuario);
	}

	public void deletar(int id) throws EntidadeNaoEncontradaException {
		Usuario usuario = pesquisar(id);
		em.remove(usuario);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			// Exibe o "log" do problema ocorrido
			e.printStackTrace();
			em.getTransaction().rollback();
			// Lançar uma exception
			throw new CommitException();
		}
	}

}
