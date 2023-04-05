package br.com.fiap.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEcontradaException;

public abstract class GenericDaoImpl<E,K> implements GenericDao<E, K>{

	private EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		//Obter o .class de E em tempo de execucao
		this.clazz = (Class<E>) ((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	//Cadastra ou atualiza
	public void salvar(E entidade) {
		em.merge(entidade);
	};

	public void deletar(K id) throws EntidadeNaoEcontradaException {
		E entidade = buscar(id);
		em.remove(entidade);
	}

	public E buscar(K id) throws EntidadeNaoEcontradaException {
		E entidade = em.find(clazz, id);
		if (entidade == null) {
			throw new EntidadeNaoEcontradaException();
		}
		return entidade;
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
