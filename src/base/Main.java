package base;

import java.sql.*;

import view.view4Botoes;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		bancoDeDados bd = new bancoDeDados();
		Connection connection = bd.recuperaConexao();
		Statement std = connection.createStatement();
		std.execute("CREATE TABLE IF NOT EXISTS pacientes(\r\n"
				+ "				codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "				nome VARCHAR (25),\r\n"
				+ "			    endereco VARCHAR (40),\r\n"
				+ "				observacao VARCHAR (40),\r\n"
				+ "			    dataDeNascimento  VARCHAR (15)\r\n"
				+ "			)");
        connection.close();
        new view4Botoes().setVisible(true);
	}

}
