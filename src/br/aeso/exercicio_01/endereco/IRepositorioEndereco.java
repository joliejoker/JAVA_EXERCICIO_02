package br.aeso.exercicio_01.endereco;
import java.sql.SQLException;
import java.util.ArrayList;
import br.aeso.exercicio_01.fornecedor.Fornecedor;

public interface IRepositorioEndereco {
	
	public void cadastrarEnd(Endereco endereco);
	public Fornecedor procurarEnd(Fornecedor fornecedor);
	public void atualizarEnd(Fornecedor fornecedor);
	public void removerEnd(Fornecedor fornecedor);
	public ArrayList<Endereco> listarEnd();
}
