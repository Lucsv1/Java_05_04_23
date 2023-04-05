package br.com.fiap.model;

//Enum -> conjunto de constantes
public enum Genero {
	
	FEMININO("Feminino"), 
	MASCULINO("Masculino"), 
	OUTROS("Outros Generos");
	
	private String label;
	
	Genero(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}