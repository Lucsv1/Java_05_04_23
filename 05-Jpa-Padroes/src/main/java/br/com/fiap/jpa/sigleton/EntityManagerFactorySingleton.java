package br.com.fiap.jpa.sigleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//Atributo estatico que armazena a unica instancia
	private static EntityManagerFactory emFactory;
	
	//Construtor privado
	private EntityManagerFactorySingleton() {}
	
	//Metodo estatico que cria e retorna a unica instancia
	public static EntityManagerFactory getInstance() {
		if (emFactory == null) {
			//Cria a fabrica
			emFactory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emFactory;	
	}
	
}
