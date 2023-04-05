package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;

public class TesteAtualizacao {

	//Atualizar um usuario no banco de dados
	public static void main(String[] args) {
		//Criar uma fabrica de entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o gerenciador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Criar um usuario com o codigo e as outras informacoes
		Usuario user = new Usuario("Luciana", "9979", "1235646546", "mariana@fiap.com.br", 1.8f, TipoUsuario.ADMIN);
		user.setCodigo(5);
		
		//Chamar o método para atualizar o usuario
		Usuario usuarioGerenciado = em.merge(user); //Retorna a copia da entidade gerenciada
		
		//Transacao
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		usuarioGerenciado.setNome("Joao");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
}