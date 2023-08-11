package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import referencia.Clientes;

public class ClienteDao {

	private Connection con;

	public ClienteDao(Connection con) {
		this.con = con;
	}

	public void registrarCliente(Clientes clientes) {
		try {
			String consulta = "INSERT INTO clientes(nombre_cliente, mail_cliente, tel_cliente,dir_cliente,ultima_modificacion)"
					+ "VALUES(?,?,?,?,?) ";

			try (PreparedStatement pstm = con.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, clientes.getNombreCliente());
				pstm.setString(2, clientes.getMailCliente());
				pstm.setString(3, clientes.getTelefonoCliente());
				pstm.setString(4, clientes.getDireccionCliente());
				pstm.setString(5, clientes.getRegistradoPor());
				pstm.execute();
			}
		} catch (SQLException e) {
			System.out.println("Error en registrar Cliente (DAO)" + e.getMessage());
		}

	}

	public List<Clientes> traerCliente() {
		List<Clientes> clientes = new ArrayList<>();
		try {
			String consulta = " SELECT * FROM clientes ";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				try (ResultSet rst = pstm.executeQuery()) {
					while (rst.next()) {
						Clientes cliente = new Clientes();

						cliente.setIdCliente(rst.getInt("id_cliente"));
						cliente.setNombreCliente(rst.getString("nombre_cliente"));
						cliente.setMailCliente(rst.getString("mail_cliente"));
						cliente.setTelefonoCliente(rst.getString("tel_cliente"));
						cliente.setDireccionCliente(rst.getString("dir_cliente"));
						cliente.setRegistradoPor(rst.getString("ultima_modificacion"));

						clientes.add(cliente);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA CONSULTA CLIENTE-DAO " + e.getMessage());
		}

		return clientes;
	}

	public String obtenerNombreCliente(int id) {
		String nombre;
		try {
			String consulta = "SELECT nombre_cliente FROM clientes WHERE id_cliente = ?";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setInt(1, id);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {

						nombre = rst.getString("nombre_cliente");
						return nombre;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public Clientes traerClienteConId(int id) {
		Clientes cliente = new Clientes();
		try {
			String consulta = " SELECT * FROM clientes WHERE id_cliente = ? ";

			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setInt(1, id);
				try (ResultSet rst = pstm.executeQuery()) {

					while (rst.next()) {

						cliente.setIdCliente(rst.getInt("id_cliente"));
						cliente.setNombreCliente(rst.getString("nombre_cliente"));
						cliente.setMailCliente(rst.getString("mail_cliente"));
						cliente.setTelefonoCliente(rst.getString("tel_cliente"));
						cliente.setDireccionCliente(rst.getString("dir_cliente"));
						cliente.setRegistradoPor(rst.getString("ultima_modificacion"));

						return cliente;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("ERROR EN LA CONSULTA CLIENTE-DAO " + e.getMessage());
		}

		return cliente;
	}

	public void actualizarCliente(Clientes clientes) {
		try {
			String consulta = "UPDATE clientes SET nombre_cliente = ?, mail_cliente = ? , tel_cliente = ?,dir_cliente = ?, ultima_modificacion = ? WHERE id_cliente = ? ";
			try (PreparedStatement pstm = con.prepareStatement(consulta)) {
				pstm.setString(1, clientes.getNombreCliente());
				pstm.setString(2, clientes.getMailCliente());
				pstm.setString(3, clientes.getTelefonoCliente());
				pstm.setString(4, clientes.getDireccionCliente());
				pstm.setString(5, clientes.getRegistradoPor());
				pstm.setInt(6, clientes.getIdCliente());
				pstm.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}

	}
}
