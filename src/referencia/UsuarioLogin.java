
// CLASE PARA EL LOGIN 
package referencia;

public class UsuarioLogin {

	private String estatus;
	private String rol;

	public UsuarioLogin() {
		super();
	}

	public UsuarioLogin(String estatus, String rol) {
		super();
		this.estatus = estatus;
		this.rol = rol;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
