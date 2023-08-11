package referencia;



public class Usuario {
	
	private int id;
	private String nombre;
	private String correo;
	private String telefono;
	private String rol;
	private String username;
	private String pass;
	private String activo;
	private String guardadoPor;
	
	
	
	public Usuario() {
		super();
	}
	
	
	
	public Usuario(int id, String nombre, String correo, String telefono, String rol, String username, String pass,
			String activo, String guardadoPor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.rol = rol;
		this.username = username;
		this.pass = pass;
		this.activo = activo;
		this.guardadoPor = guardadoPor;
	}



	public Usuario(String nombre, String correo, String telefono, String rol, String username, String pass,
			String activo, String guardadoPor) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.rol = rol;
		this.username = username;
		this.pass = pass;
		this.activo = activo;
		this.guardadoPor = guardadoPor;
	}


	public Usuario(int id, String nombre, String correo, String telefono, String rol, String username, String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.rol = rol;
		this.username = username;
		this.activo = activo;
	}



	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}


	public String getGuardadoPor() {
		return guardadoPor;
	}


	public void setGuardadoPor(String guardadoPor) {
		this.guardadoPor = guardadoPor;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	

}
