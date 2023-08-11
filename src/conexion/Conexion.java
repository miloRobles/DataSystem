package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	private String url = "jdbc:mysql://localhost/bd_ds?servertTimezone=UTC";
	private String usuario = "root";
	private String pass = "";
	private Connection con;
	
	
	public Connection obtenerConexion() {
		
		try {
			con = DriverManager.getConnection(url,usuario,pass);
			return con;
		} catch (SQLException e) {
			System.out.println("Error  al conectar"+ e.getMessage());
		}
		return (null);
	}

}
