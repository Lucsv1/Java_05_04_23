package br.com.fiap.view;

import br.com.fiap.dao.OrmDao;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Animal;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um Aluno
		Aluno aluno = new Aluno();
		
		//Instanciar um OrmDao
		OrmDao dao = new OrmDao();
		
		//Chamar o método pesquisar passando o aluno
		dao.pesquisar(aluno);
		
		//Instanciar um Animal
		Animal animal = new Animal();
		
		//Chamar o método pesquisar passando o animal
		dao.pesquisar(animal);
		
	}
}
