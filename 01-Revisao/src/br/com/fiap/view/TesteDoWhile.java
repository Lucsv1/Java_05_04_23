package br.com.fiap.view;

import java.util.Scanner;

public class TesteDoWhile {

	public static void main(String[] args) {
		
		//Objeto para ler o teclado do usuario
		Scanner sc = new Scanner(System.in);
		
		String palavra;
		
		//Ler uma String até que o usuário digite "sair"
		do {
			System.out.println("Digite uma palavra");
			palavra = sc.next();
			System.out.println("Palavra digitada: " + palavra);
		} while (!palavra.equals("sair"));
		
		System.out.println("Saindo do sistema..");
		
		//Fechar o leitor
		sc.close();
	}
}