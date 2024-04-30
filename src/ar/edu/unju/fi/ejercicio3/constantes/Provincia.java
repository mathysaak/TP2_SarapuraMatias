package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(700000,59000),
	SALTA(1180000,120000),
	TUCUMAN(1540000,22000),
	CATAMARCA(850000,102000),
	LA_RIOJA(611000,131000),
	SANTIAGO_DEL_ESTERO(1120000,50000);
	
	private int poblacion;
	private int superficie;
	
	private Provincia(int poblacion, int superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double densidadPoblacion() {

		return this.getPoblacion() / this.getSuperficie();
	}
	
}

