package referencia;

public class Clientes {
	
	private int idCliente;
	private String nombreCliente;
	private String mailCliente;
	private String telefonoCliente;
	private String direccionCliente;
	private String registradoPor;
	
	
	public Clientes() {
	}
	
	public Clientes(String nombreCliente, String mailCliente, String telefonoCliente, String direccionCliente,
			String registradoPor) {
		this.nombreCliente = nombreCliente;
		this.mailCliente = mailCliente;
		this.telefonoCliente = telefonoCliente;
		this.direccionCliente = direccionCliente;
		this.registradoPor = registradoPor;
	}
	public Clientes(int idCliente, String nombreCliente, String mailCliente, String telefonoCliente,
			String direccionCliente, String registradoPor) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.mailCliente = mailCliente;
		this.telefonoCliente = telefonoCliente;
		this.direccionCliente = direccionCliente;
		this.registradoPor = registradoPor;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getMailCliente() {
		return mailCliente;
	}
	public void setMailCliente(String mailCliente) {
		this.mailCliente = mailCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getRegistradoPor() {
		return registradoPor;
	}
	public void setRegistradoPor(String registradoPor) {
		this.registradoPor = registradoPor;
	}
	

}
