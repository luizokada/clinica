package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bancoDeDados {
	public Connection recuperaConexao() throws SQLException {
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC", "root", "Omegacode@01");
	}

}
