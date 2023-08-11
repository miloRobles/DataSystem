package referencia;

public class Estatus {

	private int enRevision;
	private int entregado;
	private int noReparado;
	private int nuevoingreso;
	private int reparado;

	public Estatus() {

	}

	public Estatus(int enRevision, int entregado, int noReparado, int nuevoingreso, int reparado) {

		this.enRevision = enRevision;
		this.entregado = entregado;
		this.noReparado = noReparado;
		this.nuevoingreso = nuevoingreso;
		this.reparado = reparado;
	}

	public int getEnRevision() {
		return enRevision;
	}

	public void setEnRevision(int enRevision) {
		this.enRevision = enRevision;
	}

	public int getEntregado() {
		return entregado;
	}

	public void setEntregado(int entregado) {
		this.entregado = entregado;
	}

	public int getNoReparado() {
		return noReparado;
	}

	public void setNoReparado(int noReparado) {
		this.noReparado = noReparado;
	}

	public int getNuevoingreso() {
		return nuevoingreso;
	}

	public void setNuevoingreso(int nuevoingreso) {
		this.nuevoingreso = nuevoingreso;
	}

	public int getReparado() {
		return reparado;
	}

	public void setReparado(int reparado) {
		this.reparado = reparado;
	}

}
