package controlador;

import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import modelo.ClienteDao;
import referencia.Clientes;

public class ClienteControlador {

	private ClienteDao clienteDao;

	public ClienteControlador() {

		Connection con = new Conexion().obtenerConexion();
		clienteDao = new ClienteDao(con);

	}

	public void registrarCliente(Clientes clientes) {
		this.clienteDao.registrarCliente(clientes);

	}

	public List<Clientes> traerCliente() {

		return this.clienteDao.traerCliente();

	}

	public Clientes traerClienteConId(int id) {

		return this.clienteDao.traerClienteConId(id);

	}

	public String obtenerNombreCliente(int id) {

		return this.clienteDao.obtenerNombreCliente(id);
	}

	public void actualizarCliente(Clientes clientes) {
		this.clienteDao.actualizarCliente(clientes);

	}

}
