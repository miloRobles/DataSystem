package controlador;

import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import modelo.UsuarioDao;
import referencia.Usuario;

public class UsuarioControlador {

	private UsuarioDao usuarioDao;

	public UsuarioControlador() {

		Connection con = new Conexion().obtenerConexion();
		usuarioDao = new UsuarioDao(con);

	}

	public void agregarUsuarioC(Usuario usuario) {

		this.usuarioDao.agregarUsuario(usuario);

	}

	// VERIFICA SI USERNAME EXISTE EN LA BASE DE DATOS

	public boolean verificacionUser(String username) {

		return this.usuarioDao.verificacionUser(username);

	}

	// TRAE LISTA DE USUARIOS PARA MOSTRARLOS
	public List<Usuario> traerUsuario() {
		return this.usuarioDao.traerUsuario();
	}

	public Usuario traerConId(int id) {
		return this.usuarioDao.traerConId(id);

	}

	// TRAE EL USERNAME
	public String traerUsername(int id) {

		return this.usuarioDao.traerusername(id);
	}

	public boolean verificarUsernameAct(String username, int id) {

		return this.usuarioDao.verificarUsernameAct(username, id);

	}

	public void actualizarUsuarios(Usuario usuario) {

		this.usuarioDao.actualizarUsuarios(usuario);

	}

	public void actualizarContrasena(String nuevoPass, int id) {
		this.usuarioDao.actualizaContrasena(nuevoPass, id);

	}

}













