package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import referencia.Usuario;

public class UsuarioDao {

	private Connection con;

	public UsuarioDao(Connection con) {
		this.con = con;
	}

	public void agregarUsuario(Usuario usuario) {

		try {
			String consulta = "INSERT INTO usuarios(nombre_usuario, email, telefono, username,"
					+ "password, tipo_nivel, estatus, registrado_por) VALUES(?,?,?,?,?,?,?,?)";

			try (PreparedStatement pstm = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, usuario.getNombre());
				pstm.setString(2, usuario.getCorreo());
				pstm.setString(3, usuario.getTelefono());
				pstm.setString(4, usuario.getUsername());
				pstm.setString(5, usuario.getPass());
				pstm.setString(6, usuario.getRol());
				pstm.setString(7, usuario.getActivo());
				pstm.setString(8, usuario.getGuardadoPor());
				pstm.execute();

			}

		} catch (Exception e) {
			System.out.println("error en la consulta del insert" + e.getMessage());
		}
	}

	// VERIFICA SI USERNAME EXISTE EN LA BASE DE DATOS

	public boolean verificacionUser(String username) {
		System.out.println(username);
		try {
			String consulta = "SELECT username FROM usuarios WHERE username = ?";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setString(1, username);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						// if (username == rst.getString(username));
						return true;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("error en la consulta" + e.getMessage());
		}
		return false;
	}

	// BUSCA USUARIOS PARA AGREGAR AL JTABLE
	public List<Usuario> traerUsuario() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			String consulta = "SELECT id_usuario, nombre_usuario, username, tipo_nivel, estatus FROM usuarios";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {

					while (rst.next()) {
						Usuario usuario = new Usuario();
						usuario.setId(rst.getInt("id_usuario"));
						usuario.setNombre(rst.getString("nombre_usuario"));
						usuario.setUsername(rst.getString("tipo_nivel"));
						usuario.setRol(rst.getString("tipo_nivel"));
						usuario.setActivo(rst.getString("estatus"));

						usuarios.add(usuario);

					}
				}
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}

		return usuarios;
	}

	// BUSCAR USUARIOS POR ID PARA ACTUALIZAR
	public Usuario traerConId(int id) {
		Usuario usuario = new Usuario();
		try {
			String consulta = "SELECT * FROM usuarios WHERE id_usuario = ?";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setInt(1, id);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						usuario.setNombre(rst.getString("nombre_usuario"));
						usuario.setCorreo(rst.getString("email"));
						usuario.setTelefono(rst.getString("telefono"));
						usuario.setRol(rst.getString("tipo_nivel"));
						usuario.setUsername(rst.getString("username"));
						usuario.setActivo(rst.getString("estatus"));
						usuario.setPass(rst.getString("password"));
						usuario.setGuardadoPor(rst.getString("registrado_por"));
					}
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta " + e.getMessage());
		}
		return usuario;
	}

	// BUSCA EL USERNAME
	public String traerusername(int id) {
		String username = "";
		try {
			String consulta = "SELECT username FROM usuarios WHERE id_usuario = ?";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setInt(1, id);
				try (ResultSet rst = pstm.executeQuery()) {
					if (rst.next()) {
						username = rst.getString("username");
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}
		return username;

	}

	// VERIFICA QUE EL USERNMAME NO SE DUPLIQUE
	public boolean verificarUsernameAct(String username, int id) {

		try {
			String consulta = "SELECT username FROM usuarios WHERE username = ? AND NOT id_usuario = ?";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setString(1, username);
				pstm.setInt(2, id);

				try (ResultSet rst = pstm.executeQuery()) {
					if (rst.next()) {
						return false;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error en la consulta ");
		}
		return true;

	}

	// ACTUALIZAR USUARIOS
	public void actualizarUsuarios(Usuario usuario) {
		try {
			String consulta = "UPDATE usuarios SET nombre_usuario = ?, email = ?, telefono = ?, username =?, tipo_nivel = ?, estatus = ?  WHERE id_usuario = ?";
			try (PreparedStatement pst = con.prepareStatement(consulta)) {

				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getCorreo());
				pst.setString(3, usuario.getTelefono());
				pst.setString(4, usuario.getUsername());
				pst.setString(5, usuario.getRol());
				pst.setString(6, usuario.getActivo());
				pst.setInt(7, usuario.getId());
				pst.execute();

			}

		} catch (Exception e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}
	}

	// ACTUALIZAR CONTRASEÑA
	public void actualizaContrasena(String nuevoPass, int id) {
		try {
			String consulta = "UPDATE usuarios SET password = ? WHERE id_usuario =? ";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {

				pstm.setString(1, nuevoPass);
				pstm.setInt(2, id);
				pstm.execute();
			}

		} catch (SQLException e) {
			System.out.println("Error en al consulta " + e.getMessage());
		}

	}
}
			
















