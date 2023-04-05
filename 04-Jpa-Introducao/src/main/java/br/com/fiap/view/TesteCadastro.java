package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

public class TesteCadastro {

	public static void main(String[] args) {
		//Instanciar um Usuario 
		Usuario user = new Usuario("Renato Augusto", "123", 
				"45654654646", "renato@timao.com", 1.8f, TipoUsuario.DEFAULT);

		//Criar a fabrica de Entity Manager
		EntityManagerFactory fabrica =
			Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o entity manager utilizando a fabrica
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar o Usuario
		em.persist(user);
		
		//Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
		
//		user.setNome("Maria");
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
	}
}