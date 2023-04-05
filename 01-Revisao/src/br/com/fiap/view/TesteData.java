package br.com.fiap.view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		//Criar um objeto do tipo Calendar com a data atual
		Calendar dataHoje = Calendar.getInstance();
		
		//Criar um objeto do tipo Calendar com a data 30/11/2023
											//ano, mes, dia
		Calendar data = new GregorianCalendar(2023, Calendar.NOVEMBER, 30);
		
		//Exibir a data
		System.out.println(dataHoje);

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println(formatador.format(dataHoje.getTime()));
		
		//Exibir a data 
		System.out.println(formatador.format(data.getTime()));
		
	}
}