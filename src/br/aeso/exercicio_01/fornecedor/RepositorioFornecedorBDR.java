package br.aeso.exercicio_01.fornecedor;
import java.sql.*;
import java.util.ArrayList;
import br.aeso.exercicio_01.util.FornecedorJaCadastradoException;




public class RepositorioFornecedorBDR implements IRepositorioFornecedor{
	
	private Fornecedor fornecedor;
	Connection conn;
	PreparedStatement preStatement;
	ResultSet resultSet;
	
	public RepositorioFornecedorBDR() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void cadastrarForn(Fornecedor fornecedor) throws FornecedorJaCadastradoException {         
		String sql="insert into `projeto`.`fornecedor` (Nome, CPF, cnpj) values (?, ?, ?)";
		preStatement = null;
		resultSet = null;
		try {
			preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setString(1, fornecedor.getNome());
			preStatement.setString(2, fornecedor.getCpf());
			preStatement.setString(3, fornecedor.getCnpj());
			preStatement.execute();
			resultSet = preStatement.getGeneratedKeys();
			Integer fornId = 0;
			while(resultSet.next()){
				fornId = resultSet.getInt(1);
			}
			System.out.println("ID do Insert no Banco " + fornId);	
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public Fornecedor procurarForn(String cpf) {
		Fornecedor fornecedor = new Fornecedor(null, null, null);	
		try {
				String sql ="select * from `projeto`.`fornecedor` where cpf = ?";
				preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, cpf);
				ResultSet resultSet = preStatement.executeQuery();

				while(resultSet.next()){
					fornecedor.setCodigo(resultSet.getInt(1));
					fornecedor.setCpf(resultSet.getString(2));
					fornecedor.setCnpj(resultSet.getString(3));;
					fornecedor.setNome(resultSet.getString(4));
				}
				return fornecedor;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
	}

	
	public void atualizarForn(Fornecedor fornecedor) {
		try {
			String sql="update `projeto`.`fornecedor` set nome = ?, cnpj= ? where cpf = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, fornecedor.getNome());
			preStatement.setString(2, fornecedor.getCnpj());
			preStatement.setString(3, fornecedor.getCpf());	
			preStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removerForn(String cpf) {
		try {
			String sql = "delete from `projeto`.`fornecedor` where cpf = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, fornecedor.getCpf());
			
			preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Fornecedor> listarForn() {
		try {
			String sql = "Select * from `projeto`.fornecedor;";
			preStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void fecharConexaoJDBC(){
		try {
			conn.close();
			preStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
