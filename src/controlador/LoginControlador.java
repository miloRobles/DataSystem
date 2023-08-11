package controlador;

import java.sql.Connection;

import conexion.Conexion;
import modelo.LoginClaseDao;
import referencia.UsuarioLogin;

public class LoginControlador {
	
	private LoginClaseDao loginClaseDao;
	
	public LoginControlador() {
		Connection con = new Conexion().obtenerConexion();
		loginClaseDao = new LoginClaseDao(con);
		
	}
	
	public UsuarioLogin verificarUsuarioControlador(String usu, String pass) {
		
		return this.loginClaseDao.verificarUsuarioDao(usu, pass);
	}
	
	public String obtenerNombre(String usu) {
		
		return this.loginClaseDao.obtenerNombre(usu);
	}	

}
