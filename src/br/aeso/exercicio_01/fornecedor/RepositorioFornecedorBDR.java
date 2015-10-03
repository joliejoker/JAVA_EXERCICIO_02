package br.aeso.exercicio_01.fornecedor;
import java.sql.*;
import java.util.ArrayList;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;




public class RepositorioFornecedorBDR implements IRepositorioFornecedor{
	
	private Fornecedor fornecedor;
	PreparedStatement preStatement;
	Connection conn;
	
	public RepositorioFornecedorBDR() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorJaCadastradoException {
		try {
			String sql="insert into fornecedor (codigo, nome, cpf, banco, endereco) values (?, ?, ?, ?, ?)";
			conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, fornecedor.getCodigo());
			preStatement.setString(2, fornecedor.getNome());
			preStatement.setString(3, fornecedor.getCpf());
			preStatement.setString(4, fornecedor.getBanco());
			preStatement.setObject(5, fornecedor.getEndereco());
			preStatement.execute();
			ResultSet resultSet = preStatement.getGeneratedKeys();
			Integer clienteId = 0;
			while(resultSet.next()){
				clienteId = resultSet.getInt(1);
			}
			System.out.println("ID do Insert no Banco " + clienteId);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Fornecedor procurarForn(String cpf) {
			try {
				String sql ="select * from cliente where cliente_id = ?";
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, fornecedor.getCpf());
				ResultSet resultSet = preStatement.executeQuery();
				
				System.out.println("Imprimindo dados do banco:");
				System.out.println("ID\tID\tNome\t\tCPF");
				while(resultSet.next()){
					System.out.println(resultSet.getString(1) + "\t");
					System.out.println(resultSet.getString("cliente_id") + "\t");
					System.out.println(resultSet.getString("nome") + "\t");
					System.out.println(resultSet.getString("cpf") + "\t");
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
	}

	
	public void atualizarForn(String cpf) {
		try {
			String sql="update cliente set nome = ? where cliente_id = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, fornecedor.getNome());
			preStatement.setInt(2, fornecedor.getCodigo());
			
			preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removerForn(Integer codigo) {
		try {
			String sql = "delete from cliente where cliente_id = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setInt(1, fornecedor.getCodigo());
			
			preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Fornecedor> listarForn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
