package br.aeso.exercicio_01.fornecedor;

import java.util.ArrayList;

import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;

public interface IRepositorioFornecedor {
	
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorJaCadastradoException;
	public Fornecedor procurarForn(String cpf);
	public void atualizarForn(String cpf);
	public void removerForn(Integer codigo);
	public ArrayList<Fornecedor> listarForn();
	
}
