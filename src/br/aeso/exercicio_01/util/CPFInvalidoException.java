package br.aeso.exercicio_01.util;


public class CPFInvalidoException extends Exception{
	private String cpf;
	
	public CPFInvalidoException(String cpf){
		super("CPF" + cpf + "nulo ou inv�lido");
		this.cpf = cpf;
	}
}
