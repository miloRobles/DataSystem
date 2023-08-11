package referencia;

public class Equipos {
	
	private int idEquipo;
	private int  idCliente;
	private String tipoEquipo;
	private String marca;
	private String modelo;
	private String numSerie;
	private String diaIngreso;
	private String mesIngreso;
	private String annioIngreso;
	private String observaciones;
	private String estatus;
	private String ultimaModificacion;
	private String comentarios;
	private String revisionDe;
	
	public Equipos() {
		
	}
	public Equipos(Integer idEquipo,  String tipoEquipo, String marca, String modelo, String numSerie, String observaciones,
			String estatus, String ultimaModificacion) {
		this.idEquipo = idEquipo;
		this.tipoEquipo = tipoEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.observaciones = observaciones;
		this.estatus = estatus;
		this.ultimaModificacion = ultimaModificacion;
	}
	
	
	public Equipos(int idCliente, String tipoEquipo, String marca, String modelo, String numSerie, String diaIngreso,
			String mesIngreso, String annioIngreso, String observaciones, String estatus, String ultimaModificacion,
			String comentarios, String revisionDe) {
		
		this.idCliente = idCliente;
		this.tipoEquipo = tipoEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.diaIngreso = diaIngreso;
		this.mesIngreso = mesIngreso;
		this.annioIngreso = annioIngreso;
		this.observaciones = observaciones;
		this.estatus = estatus;
		this.ultimaModificacion = ultimaModificacion;
		this.comentarios = comentarios;
		this.revisionDe = revisionDe;
	}


	public Equipos(String tipoEquipo, String marca, String modelo, String numSerie, String diaIngreso,
			String mesIngreso, String annioIngreso, String observaciones, String estatus, String revisionDe) {
		
		this.tipoEquipo = tipoEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.diaIngreso = diaIngreso;
		this.mesIngreso = mesIngreso;
		this.annioIngreso = annioIngreso;
		this.observaciones = observaciones;
		this.estatus = estatus;
		this.revisionDe = revisionDe;
	}
	public Equipos(int idEquipo, int idCliente, String tipoEquipo, String marca, String modelo, String numSerie,
			String diaIngreso, String mesIngreso, String annioIngreso, String observaciones, String estatus,
			String ultimaModificacion, String comentarios, String revisionDe) {
		this.idEquipo = idEquipo;
		this.idCliente = idCliente;
		this.tipoEquipo = tipoEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.diaIngreso = diaIngreso;
		this.mesIngreso = mesIngreso;
		this.annioIngreso = annioIngreso;
		this.observaciones = observaciones;
		this.estatus = estatus;
		this.ultimaModificacion = ultimaModificacion;
		this.comentarios = comentarios;
		this.revisionDe = revisionDe;
	}
	public Equipos(String tipoEquipo, String marca, String modelo, String numSerie, String diaIngreso,
			String mesIngreso, String annioIngreso, String observaciones, String estatus, String ultimaModificacion,
			String comentarios, String revisionDe) {
	
		this.tipoEquipo = tipoEquipo;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.diaIngreso = diaIngreso;
		this.mesIngreso = mesIngreso;
		this.annioIngreso = annioIngreso;
		this.observaciones = observaciones;
		this.estatus = estatus;
		this.ultimaModificacion = ultimaModificacion;
		this.comentarios = comentarios;
		this.revisionDe = revisionDe;
	}
	
		
	public Equipos(int idEquipo , String estatus, String comentarios, String revisionDe) {
		this.idEquipo = idEquipo;
		this.estatus = estatus;
		this.comentarios = comentarios;
		this.revisionDe = revisionDe;
	}
	
	
	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoEquipo() {
		return tipoEquipo;
	}
	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getDiaIngreso() {
		return diaIngreso;
	}
	public void setDiaIngreso(String diaIngreso) {
		this.diaIngreso = diaIngreso;
	}
	public String getMesIngreso() {
		return mesIngreso;
	}
	public void setMesIngreso(String mesIngreso) {
		this.mesIngreso = mesIngreso;
	}
	public String getAnnioIngreso() {
		return annioIngreso;
	}
	public void setAnnioIngreso(String annioIngreso) {
		this.annioIngreso = annioIngreso;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getUltimaModificacion() {
		return ultimaModificacion;
	}
	public void setUltimaModificacion(String ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getRevisionDe() {
		return revisionDe;
	}
	public void setRevisionDe(String revisionDe) {
		this.revisionDe = revisionDe;
	}
	

}
