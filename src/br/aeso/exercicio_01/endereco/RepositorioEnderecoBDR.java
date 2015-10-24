package br.aeso.exercicio_01.endereco;
import java.sql.*;
import java.util.ArrayList;
import br.aeso.exercicio_01.fornecedor.Fornecedor;



public class RepositorioEnderecoBDR implements IRepositorioEndereco{

	Connection conn;
	PreparedStatement preStatement;
	private Endereco endereco;
	
	public RepositorioEnderecoBDR() {
		// TODO Auto-generated constructor stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	@Override
	public void cadastrarEnd(Endereco endereco){
		 try {
			 String sql="insert into endereco (codigo, rua, numero, complemento, bairro, cidade, estado, cep) values (?, ?, ?, ?, ?, ?, ?)";
			conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preStatement.setInt(1, endereco.getfornecedor().getCodigo());
			preStatement.setString(2, endereco.getrua());
			preStatement.setString(3, endereco.getnumero());
			preStatement.setString(4, endereco.getcomplemento());
			preStatement.setString(5, endereco.getbairro());
			preStatement.setString(6, endereco.getcidade());
			preStatement.setString(6, endereco.getcep());
			preStatement.execute();
			
			ResultSet resultSet = preStatement.getGeneratedKeys();
			Integer clienteId= 0;
			while(resultSet.next()){
				clienteId = resultSet.getInt(1);
			}
			System.out.println("ID do insert do banco: " + clienteId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}

	@Override
	public Fornecedor procurarEnd(Fornecedor fornecedor) {
		try {
			String sql = "select * from cliente where cliente_id = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, endereco.getfornecedor().getCpf());
			ResultSet resultSet = preStatement.executeQuery();
			
			System.out.println("Imprimindo Dados do Banco");
			System.out.println("ID\tID\tNome\t\tRua");
			while(resultSet.next()){
				System.out.println(resultSet.getString(1) + "\t");
				System.out.println(resultSet.getString("cliente_id") + "\t");
				System.out.println(resultSet.getString("nome") + "\t");
				System.out.println(resultSet.getString("Rua") + "\t");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizarEnd(Fornecedor fornecedor) {
		try {
			String sql = "update endereco set nome = ? where cliente_id = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setObject(1, endereco.getfornecedor().getNome());
			preStatement.setInt(2, endereco.getfornecedor().getCodigo());
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removerEnd(Fornecedor fornecedor) {
		try {
			String sql = "delete from endereco where cliente_id = ?";
			preStatement = conn.prepareStatement(sql);
			preStatement.setObject(1, endereco.getfornecedor().getCodigo());
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<Endereco> listarEnd() {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	

	

}
