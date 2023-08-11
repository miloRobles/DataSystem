package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import referencia.UsuarioLogin;

public class LoginClaseDao {

	private Connection con;

	public LoginClaseDao(Connection con) {
		this.con = con;
	}

	public UsuarioLogin verificarUsuarioDao(String usu, String pass) {
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		try {

			String consulta = "SELECT tipo_nivel, estatus FROM usuarios WHERE username = ? && password = ? ";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {

				pstm.setString(1, usu);
				pstm.setString(2, pass);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {

					while (rst.next()) {
						usuarioLogin.setEstatus(rst.getString("estatus"));
						usuarioLogin.setRol(rst.getString("tipo_nivel"));
						return usuarioLogin;
					}
				}
			}
		} catch (SQLException e) {

			System.out.println("error en la base de datos" + e.getMessage());
		}
		return null;
	}

	// OBTIENE EL NOMBRE DEL USUARIO DUEÑO DE LA SESIÓN
	public String obtenerNombre(String usu) {

		String nombre;
		try {
			String consulta = "SELECT nombre_usuario FROM usuarios WHERE username = ?";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setString(1, usu);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {

						nombre = rst.getString("nombre_usuario");
						return nombre;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}