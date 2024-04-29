package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	
	private String codigo;
	private String descripcion;
	private int precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	public Producto(String codigo, String descripcion, int precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	public Producto( OrigenFabricacion origenFabricacion,
			Categoria categoria) {

		this.codigo = "";
		this.descripcion = "";
		this.precioUnitario = 0;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}

	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

}