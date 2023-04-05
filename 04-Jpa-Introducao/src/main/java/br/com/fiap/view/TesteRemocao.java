package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Usuario;

public class TesteRemocao {
	
	//Apagar um usuario do banco
	public static void main(String[] args) {
		//Criar a fabrica 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o usuario pela PK
		Usuario churros = em.find(Usuario.class, 5);
		
		//Chamar o metodo para remover
		em.remove(churros);
		
		//Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
}
