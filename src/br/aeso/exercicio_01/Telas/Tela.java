package br.aeso.exercicio_01.Telas;

import br.aeso.exercicio_01.fachada.Fachada;
import br.aeso.exercicio_01.fornecedor.Fornecedor;
import br.aeso.exercicio_01.util.CPFInvalidoException;
import br.aeso.exercicio_01.util.FornecedorInvalidoException;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;

public class Tela {
		// 754.621.443-26
		// 345.135.354-74
		// 171.093.227-93
	public static void main(String []args){
		Fachada fachada = Fachada.getInstance();
		
		Fornecedor fornecedor = new Fornecedor(1, "Mauricio Manoel", "754.621.443-26", "Santander");
		
			try {
				fachada.cadastrarForn(fornecedor);
			} catch (FornecedorInvalidoException | CPFInvalidoException | FornecedorJaCadastradoException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				e1.getMessage();
			}
			
			try {
				System.out.println(fachada.procurarForn("754.621.443-26"));
			} catch (CPFInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

}
