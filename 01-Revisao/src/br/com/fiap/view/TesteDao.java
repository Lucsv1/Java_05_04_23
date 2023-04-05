package br.com.fiap.view;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.AlunoDaoJpa;

public class TesteDao {

	public static void main(String[] args) {
		
		AlunoDao dao = new AlunoDaoJpa();
		
	}
}