package DAO;

public class Usuario {
	private long idUsuario;
	private String nombre;
	private String email;
	private long telefonoLocal;

	public Usuario() {
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefonoLocal() {
		return telefonoLocal;
	}

	public void setTelefonoLocal(long telefonoLocal) {
		this.telefonoLocal = telefonoLocal;
	}
}