package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.UsuarioDaoImpl;
import br.com.fiap.entity.TipoUsuario;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

public class TesteDao {

	//Verificar se os metodos do DAO estao funcionando
	public static void main(String[] args) {
		//Criar uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

		//Criar um Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um DAO
		UsuarioDao dao = new UsuarioDaoImpl(em);
		
		//Cadastrar um usuario	
		Usuario usuario = new Usuario("Raphael", "12345", "1235546554", "raphael@fiap.com.br", 1.8f, TipoUsuario.ADMIN);
		try {
			dao.cadastrar(usuario);
			dao.commit();
			System.out.println("Usuário cadastrado!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um usuario
		try {
			Usuario busca = dao.pesquisar(3);
			System.out.println(busca.getNome());
		}catch(EntidadeNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar um usuario
		usuario.setNome("Renato");
		try {
			dao.atualizar(usuario);
			dao.commit();
			System.out.println("Usuario atualizado");
		} catch (EntidadeNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (CommitException e) {
			System.out.println("Erro ao realizar o commit");
		}
		
		//Remover um usuario
		try {
			dao.deletar(3);
			dao.commit();
			System.out.println("Usuário removido!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
