package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.LivroDao;
import br.com.fiap.jpa.dao.LivroDaoImpl;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntidadeNaoEcontradaException;
import br.com.fiap.jpa.sigleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma fabrica de Entity Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o LivroDao
		LivroDao dao = new LivroDaoImpl(em);
		
		List<String> lista = new ArrayList<String>();
		
		//Instaciar um Livro (criar o construtor)
		Livro livro = new Livro("Jo�o e Maria", 
				Genero.AVENTURA, 390, new GregorianCalendar(1812, Calendar.DECEMBER, 20));
		
		//Cadastrar um Livro
		try {
			dao.salvar(livro);
			dao.commit();
			System.out.println("Livro cadastrado!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um livro pelo id
		try {
			Livro busca = dao.buscar(1);
			System.out.println(busca.getTitulo());
		} catch (EntidadeNaoEcontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		
		
		//Atualizar um livro
		try {
			livro.setCodigo(1);
			livro.setTitulo("god of war");
			dao.salvar(livro);
			dao.commit();
			System.out.println("Atualizado");
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());;
		}
		
		//Remover um livro
		
		try {
			Livro busca = dao.buscar(1);
			dao.deletar(1);
			dao.commit();
			System.out.println("o livro esta deletado " + busca);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}