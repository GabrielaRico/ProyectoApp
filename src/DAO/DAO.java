package DAO;

import java.util.ArrayList;

public interface DAO {
	 public boolean Alta(Object o);
	    public boolean Actualizar(Object o);
	    public boolean Eliminar(Object o);
	    public ArrayList Consulta(String descripcion);

}
