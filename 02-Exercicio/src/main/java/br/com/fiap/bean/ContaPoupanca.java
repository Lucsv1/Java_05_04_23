package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	public static final float RENDIMENTO = 0.05f; //f no final, define que o n�mero � do tipo float
	
	public double calculaRetornoInvestimento() {
		return RENDIMENTO * saldo;
	}
	
	//CTRL + 3 -> gcuf
	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (saldo < valor + taxa) {
			throw new SaldoInsuficienteException("Saldo insufuciente");
		}
		saldo -= valor + taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}