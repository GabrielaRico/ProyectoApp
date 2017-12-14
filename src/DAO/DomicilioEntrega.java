package DAO;

public class DomicilioEntrega {
	private long idDomicilioEntrega;
	private String calle;
	private long numeroint;
	private long numeroext;
	private String colonia;
	private String delegacion;
	
	public long getIdDomicilioEntrega() {
		return idDomicilioEntrega;
	}
	public void setIdDomicilioEntrega(long idDomicilioEntrega) {
		this.idDomicilioEntrega = idDomicilioEntrega;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public long getNumeroint() {
		return numeroint;
	}
	public void setNumeroint(long numeroint) {
		this.numeroint = numeroint;
	}
	public long getNumeroext() {
		return numeroext;
	}
	public void setNumeroext(long numeroext) {
		this.numeroext = numeroext;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

}
