package br.aeso.conexaoJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBD {

	public static void main(String[] args) throws SQLException {
		
			PreparedStatement preStatement;
			Connection conn = null;
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/juliana", "root", "root");
			String sql = "Select * from cliente";
			preStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("nome"));
			}
			

}
}	
