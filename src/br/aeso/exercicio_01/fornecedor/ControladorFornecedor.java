package br.aeso.exercicio_01.fornecedor;
import java.util.ArrayList;
import br.aeso.exercicio_01.util.CPFInvalidoException;
import br.aeso.exercicio_01.util.CampoObrigatorioInvalidoException;
import br.aeso.exercicio_01.util.FornecedorInvalidoException;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;
import br.aeso.exercicio_01.util.ValidarCPF;


public class ControladorFornecedor {
		
	
	private IRepositorioFornecedor repositorioFornecedorBDR;
	private ControladorFornecedor controladorFornecedor;
	
	public ControladorFornecedor(){
		//controladorFornecedor = new ControladorFornecedor();
		repositorioFornecedorBDR = new RepositorioFornecedorBDR();
	}
	

	
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorInvalidoException,
															CPFInvalidoException, 
															FornecedorJaCadastradoException{
		//controladorFornecedor.cadastrarForn(fornecedor);
		//if(fornecedor.equals(fornecedor.getCpf())) throw new FornecedorJaCadastradoException();
		if(fornecedor == null) throw new FornecedorInvalidoException();
		if(!ValidarCPF.validaCPF(fornecedor.getCpf())) throw new CPFInvalidoException(fornecedor.getCpf());
		else{
		this.repositorioFornecedorBDR.cadastrarForn(fornecedor);
		}
		
	}
	
	public Fornecedor procurarForn(String cpf) throws CPFInvalidoException{
		Fornecedor fornecedor = null;		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		else{
			return controladorFornecedor.procurarForn(cpf);
		}
		
	}
	
	public void atualizarForn(String cpf) throws CPFInvalidoException, 
												 CampoObrigatorioInvalidoException{
		Fornecedor fornecedor = null;
		if(!ValidarCPF.validaCPF(fornecedor.getCpf())) throw new CPFInvalidoException(fornecedor.getCpf());
		else if(fornecedor.getNome() == "") throw new CampoObrigatorioInvalidoException();
		else{
		controladorFornecedor.atualizarForn(cpf);
		}		
	}
	
	public void removerForn(String cpf) throws CPFInvalidoException{
		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		else{
		controladorFornecedor.removerForn(cpf);
		}		
	}
	
	public ArrayList<Fornecedor> listarForn() throws CPFInvalidoException{
		ArrayList<Fornecedor> fornecedores = null;
		
		fornecedores  = this.controladorFornecedor.listarForn();
		for (Fornecedor fornecedor : fornecedores) {
			try {
				fornecedor = controladorFornecedor.procurarForn(fornecedor.getCpf());
			} catch (CPFInvalidoException e) {}
		}
		return fornecedores;
	}

}
