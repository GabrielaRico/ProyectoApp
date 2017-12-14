package DAO;

public class Productos {
	private int idProductos;
	private String Descripcion;
	private String Tipo;
	private float Precio;
	
	public int getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float Precio) {
		this.Precio = Precio;
	}
	
	

}
