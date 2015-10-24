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
		Fornecedor fornecedor2;
		fornecedor2 = repositorioFornecedorBDR.procurarForn(fornecedor.getCpf());
		String cpf = fornecedor2.getCpf();
		if(fornecedor.getCpf().equals(cpf)) throw new FornecedorJaCadastradoException();
		//if(fornecedor2 != null) throw new FornecedorJaCadastradoException();
		if(!ValidarCPF.validaCPF(fornecedor.getCpf())) throw new CPFInvalidoException(fornecedor.getCpf());
		if(fornecedor == null) throw new FornecedorInvalidoException();
		else{
		repositorioFornecedorBDR.cadastrarForn(fornecedor);
		}
		
	}
	
	public Fornecedor procurarForn(String cpf) throws CPFInvalidoException{	
		//Fornecedor fornecedor = null;
		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		
			return repositorioFornecedorBDR.procurarForn(cpf);
		
		
	}
	
	public void atualizarForn(Fornecedor fornecedor) throws CPFInvalidoException, CampoObrigatorioInvalidoException{
		
		if(!ValidarCPF.validaCPF(fornecedor.getCpf())) throw new CPFInvalidoException(fornecedor.getCpf());
		if(fornecedor.getNome() == "") throw new CampoObrigatorioInvalidoException();
		else{
		repositorioFornecedorBDR.atualizarForn(fornecedor);
		}		
	}
	
	public void removerForn(String cpf) throws CPFInvalidoException{
		
		if(!ValidarCPF.validaCPF(cpf)) throw new CPFInvalidoException(cpf);
		else{
		repositorioFornecedorBDR.removerForn(cpf);
		}		
	}
	
	public ArrayList<Fornecedor> listarForn() throws CPFInvalidoException{
		ArrayList<Fornecedor> fornecedores = null;
		
		fornecedores  = this.repositorioFornecedorBDR.listarForn();
		/*
		for (Fornecedor fornecedor : fornecedores) {
			try {
				fornecedor = controladorFornecedor.procurarForn(fornecedor.getCpf());
			} catch (CPFInvalidoException e) {}
		}
		*/
		return fornecedores;
	}

	public void fecharConexaoJDBC(){
		repositorioFornecedorBDR.fecharConexaoJDBC();
	}
}
