package br.aeso.exercicio_01.fornecedor;

import java.util.ArrayList;

import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;

public interface IRepositorioFornecedor {
	
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorJaCadastradoException;
	public Fornecedor procurarForn(String cpf);
	public void atualizarForn(Fornecedor fornecedor);
	public void removerForn(String cpf);
	public ArrayList<Fornecedor> listarForn();
	public void fecharConexaoJDBC();
	
}
