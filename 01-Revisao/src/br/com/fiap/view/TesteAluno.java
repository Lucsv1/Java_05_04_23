package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.Genero;

public class TesteAluno {

	//Criar o metodo main
	public static void main(String[] args) {
		//Criar uma data de nascimento
		Calendar data = new GregorianCalendar(2004, Calendar.MARCH, 30);
		
		//Instanciar um aluno com o nome, genero e data nascimento
		Aluno aluno = new Aluno("Kleberson", data, Genero.OUTROS);
		
		//Verificar se o aluno possui o genero FEMININO
		if (aluno.getGenero() == Genero.FEMININO)
			System.out.println("Feminino");
		
		//Exibir o genero do aluno
		System.out.println(aluno.getGenero());
	}
}