package controlador;

import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import modelo.EquiposDao;
import referencia.Equipos;
import referencia.Estatus;

public class EquiposControlador {

	private EquiposDao equiposDao;

	public EquiposControlador() {
		Connection con = new Conexion().obtenerConexion();
		equiposDao = new EquiposDao(con);
	}

	public void registrarEquipo(Equipos equipos) {
		this.equiposDao.registrarEquipo(equipos);

	}

	public List<Equipos> informacionEquipos(int id) {
		return this.equiposDao.informacionEquipos(id);

	}

	public Equipos traerTodoEquipos(int idEquipos) {
		return this.equiposDao.traerTodoEquipos(idEquipos);
	}

	public List<Equipos> recuperarTodoEquipos() {
		return this.equiposDao.recuperTodoEquipos();
	}

	public void actualizarEquipos(Equipos equipos) {
		this.equiposDao.actualizarEquipos(equipos);

	}

	public List<Equipos> filtros(String estatus) {
		return this.equiposDao.filtros(estatus);
	}

	public void actualizarEquiposTecnico(Equipos equipos) {
		this.equiposDao.actualizarEquiposTecnico(equipos);

	}

	public Estatus obtenerCantidadPorEstatus() {
		return this.equiposDao.obtenerCantidadPorEstatus();
	}

	public int[] marcaDeEquipos() {

		return this.equiposDao.marcaDeEquipos();

	}

}
















