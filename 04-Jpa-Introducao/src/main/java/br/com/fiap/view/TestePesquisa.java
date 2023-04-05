package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Usuario;

public class TestePesquisa {

	//Pesquisar um usuario pela PK
	public static void main(String[] args) {
		//Criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o usuario pela PK
		Usuario user = em.find(Usuario.class, 1);
		
		//Exibir o nome e a PK do usuario
		System.out.println(user.getNome() + " " + user.getCodigo());
		
		user.setNome("Maria");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
	}
}