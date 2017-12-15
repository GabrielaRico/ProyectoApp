package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProveedorDAO implements DAO{
		public boolean Actualizar(Object o) {
	        boolean b = false;
	        Proveedor pro = null;
	        Datasource d = new Datasource("clariantbd.database.windows.net","3306","clariantbd","gaby","alki1380");
	        Connection c = d.getConexion();
	        String sql = "update Proveedor set idProveedor = ?,direccion = ?,email = ?,telefono = ?,descripcion = ?, where idProveedor = ?";
	        
	        try
	        {
	            PreparedStatement ps = c.prepareStatement(sql);
	            pro = (Proveedor) o;
	            ps.setLong(1, pro.getIdProveedor());
	            ps.setString(2, pro.getDireccion());
	            ps.setString(3, pro.getEmail());
	            ps.setLong(4,pro.getTelefono());
	            ps.setString(5, pro.getDescripcion());

	            int r = ps.executeUpdate();
	            if(r > 0)
	                b = true;
	        
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return b;
	    }

	public boolean Alta(Object o) {
	  boolean b = false;
      Proveedor pro = null;
      Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
      Connection c = d.getConexion();
      String sql = "insert into Proveedor (idProveedor,direccion,descripcion,email,telefono) values(?,?,?,?,?)";
      
      try
      {
          
    	  PreparedStatement ps = c.prepareStatement(sql);
          pro = (Proveedor) o;
          ps.setLong(1, pro.getIdProveedor());
          ps.setString(2, pro.getDireccion());
          ps.setString(3, pro.getEmail());
          ps.setLong(4,pro.getTelefono());
          ps.setString(5, pro.getDescripcion());
          
          int r = ps.executeUpdate();
          if(r > 0)
              b = true;
      
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
      return b;
	}
  
  
  public boolean Eliminar (Object o) {
      boolean b = false;
      Proveedor pro = null;
      Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
      Connection c = d.getConexion();
      String sql = "delete from Proveedor where idProveedor = ?)";
      
      try
      {
          
          PreparedStatement ps = c.prepareStatement(sql);
          pro = (Proveedor) o;
          ps.setLong(1,pro.getIdProveedor());
          
          int r = ps.executeUpdate();
          if(r > 0)
              b = true;
      
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
      return b;
  }

  public ArrayList<Proveedor> Consulta (String descripcion) {
      ArrayList<Proveedor> proveedores = null;
      String sql = "select * from Proveedor where descripcion like ('%"+descripcion+"%')";
      try
      {
          Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
          Connection c = d.getConexion();
          Statement s = c.createStatement();
          ResultSet rs = s.executeQuery(sql);
          proveedores = new ArrayList<Proveedor>();
          
          while(rs.next())
          {
        	  Proveedor pro = new Proveedor();
              pro.setIdProveedor(rs.getInt("idProveedor"));
              pro.setDescripcion(rs.getString("descripcion"));
              pro.setDireccion(rs.getString("direccion"));
              pro.setEmail(rs.getString("email"));
              pro.setTelefono(rs.getLong("telefono"));
              proveedores.add(pro);
          }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      
      return proveedores;
  }
}




