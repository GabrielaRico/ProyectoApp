package DAO;

import java.sql.Date;

public class Orden {
	private long idOrden;
	private Date fechaCreacion;
	private Date fechaEntrega;
	private String descripcionArticulo;
	private float precioUnitrario;
	private int numeroPiezas;
	private float total;
	private int Status;
	private int correoEnviado;
	
	public long getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public float getPrecioUnitrario() {
		return precioUnitrario;
	}
	public void setPrecioUnitrario(float precioUnitrario) {
		this.precioUnitrario = precioUnitrario;
	}
	public int getNumeroPiezas() {
		return numeroPiezas;
	}
	public void setNumeroPiezas(int numeroPiezas) {
		this.numeroPiezas = numeroPiezas;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getCorreoEnviado() {
		return correoEnviado;
	}
	public void setCorreoEnviado(int correoEnviado) {
		this.correoEnviado = correoEnviado;
	}
	


}
