package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {

	public static void main(String[] args) {
		
		//Exemplo 1
		//Calendar data = new GregorianCalendar(2020, Calendar.FEBRUARY, 23);
		//ContaCorrente cc = new ContaCorrente(123, 321, data, 500, TipoConta.COMUM);
		
		//Instanciar uma Conta Corrente e uma Conta Poupan�a
		ContaCorrente cc = new ContaCorrente(123, 321, new GregorianCalendar(2020, Calendar.FEBRUARY, 23), 500, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(123,  333, Calendar.getInstance(), 1000, 2);
		
		//Chamar o m�todo retirar da Conta Corrente
		try {
			cc.retirar(501);
			System.out.println("Saque realizado! Novo Saldo: " + cc.getSaldo());
		}catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
		//Criar uma lista de Contas Correntes
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		lista.add(cc);
		lista.add(new ContaCorrente(12, 50, Calendar.getInstance(), 100, TipoConta.ESPECIAL));
		lista.add(new ContaCorrente(12, 50, Calendar.getInstance(), 250, TipoConta.ESPECIAL));
		
		//Exibir os saldos das contas
		for (ContaCorrente item : lista) {
			System.out.println(item.getSaldo());
		}
		
	}
}