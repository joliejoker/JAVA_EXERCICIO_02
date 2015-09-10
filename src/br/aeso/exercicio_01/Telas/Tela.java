package br.aeso.exercicio_01.Telas;

import br.aeso.exercicio_01.fornecedor.Fornecedor;

public class Tela {
	
	public static void main(String []args){
		
		Fornecedor fornecedor = new Fornecedor(1, "Mauricio Manoel", "001001001-01", "Santander");
		System.out.println(fornecedor);
	}

}
