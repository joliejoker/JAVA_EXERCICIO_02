package br.aeso.exercicio_01.fornecedor;
import java.util.ArrayList;
import br.aeso.exercicio_01.util.CPFInvalidoException;
import br.aeso.exercicio_01.util.FornecedorInvalidoException;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;
import br.aeso.exercicio_01.util.ValidarCPF;


public class ControladorFornecedor {
	
	private RepositorioFornecedorBDR repositorioFornecedor;
	private ControladorFornecedor controladorFornecedor;
	
	public ControladorFornecedor(){
		repositorioFornecedor = new RepositorioFornecedorBDR();
		controladorFornecedor = new ControladorFornecedor();
	}
	
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorInvalidoException,
															CPFInvalidoException, 
															FornecedorJaCadastradoException{
		//controladorFornecedor.cadastrarForn(fornecedor);
		if(fornecedor == null) throw new FornecedorInvalidoException();
		if(!ValidarCPF.validaCPF(fornecedor.getCpf())) throw new CPFInvalidoException();
		this.repositorioFornecedor.cadastrarForn(fornecedor);
		
	}
	
	public Fornecedor procurarForn(String cpf) throws CPFInvalidoException{
		Fornecedor fornecedor = null;
	
		cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException();
		else{
			return controladorFornecedor.procurarForn(cpf);
		}
		
	}
	
	public void atualizarForn(String cpf){
		controladorFornecedor.atualizarForn(cpf);
		
	}
	
	public void removerForn(String cpf){
		controladorFornecedor.removerForn(cpf);
		
	}
	
	public ArrayList<Fornecedor> listarForn(){
		return null;
	}

}
