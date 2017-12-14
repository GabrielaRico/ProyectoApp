package DAO;

public interface DAO {
	 public boolean Alta(Object o);
	    public boolean Actualizar(Object o);
	    public boolean Eliminar(Object o);
	    public Object Consulta(String id, String parametro, String parametroDireccion);

}
