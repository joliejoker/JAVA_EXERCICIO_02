package br.aeso.conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBD {

	public static void main(String[] args) throws SQLException {
		
		PreparedStatement preStatement;
		Connection conn = null;
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost/juliana", "root", "root");
		String sql ="insert into cliente (nome, cpf, banco) values (?, ?, ?)";
		preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preStatement.setString(1, "Rosicléia");
		preStatement.setString(2, "25876932105");
		preStatement.setString(3, "Itaú");
		preStatement.execute();

	}

}
