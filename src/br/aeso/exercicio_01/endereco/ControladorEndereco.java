package br.aeso.exercicio_01.endereco;
import java.util.ArrayList;

import br.aeso.exercicio_01.fornecedor.Fornecedor;


public class ControladorEndereco {
	
	private ControladorEndereco controladorEndereco;
	private RepositorioEnderecoBDR repositorioEndereco;
	
	
	public ControladorEndereco() {
		// TODO Auto-generated constructor stub
		//controladorEndereco = new ControladorEndereco();
		repositorioEndereco = new RepositorioEnderecoBDR();
	}
	
	public void cadastrarEnd(Fornecedor fornecedor, String rua, String numero, String complemento, 
			String bairro, String cidade, String cep){
		controladorEndereco.cadastrarEnd(fornecedor, rua, numero, complemento, bairro, cidade, cep);
	}
	
	public Fornecedor procurarEnd(Fornecedor fornecedor){
		return controladorEndereco.procurarEnd(fornecedor);
	}
	
	public void atualizarEnd(Fornecedor fornecedor){
		controladorEndereco.atualizarEnd(fornecedor);
	}
	
	public void removerEnd(Fornecedor fornecedor){
		controladorEndereco.removerEnd(fornecedor);
	}
	
	public ArrayList<Endereco> listarEnd(){
		return null;
	}

}
