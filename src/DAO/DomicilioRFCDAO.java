package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DomicilioRFCDAO {
	public boolean Actualizar(Object o) {
        boolean b = false;
        Productos p = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update Productos set idProductos = ?, Descripcion = ?, Tipo = ?, Precio = ? where idProductos = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            p = (Productos) o;
            ps.setInt(1, p.getIdProductos());
            ps.setString(2, p.getDescripcion());
            ps.setString(4, p.getTipo());
            ps.setFloat(4, p.getPrecio());

            
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
        Productos p = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into Productos (Descripcion,Tipo,Precio) values(?,?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            p = (Productos) o;
            ps.setInt(1, p.getIdProductos());
            ps.setString(2, p.getDescripcion());
            ps.setString(4, p.getTipo());
            ps.setFloat(4, p.getPrecio());
            
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
        Productos p = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "delete from Productos where idProductos = ?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            p = (Productos) o;
            ps.setInt(1,p.getIdProductos());
            
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

    
    public ArrayList Consulta(String descripcion) {
        ArrayList<Productos> productos = null;
        String sql = null;
        switch(parametro)
        {
            case "idProductos":
                sql = "select * from Productos where idProductos = "+id;
                break;
            case "Descripcion":
                sql = "select * from Productos where Descripcion like ('"+id+"')";
                break;
            case "Tipo":
                sql = "select * from Productos where Tipo like ('"+id+"')";
                break;
            case "Precio":
                sql = "select * from Productos where Precio = "+id;
                break;
            

        }
        
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next())
            {
                Productos p = new Productos();
                p.setIdProductos(rs.getInt("idProductos"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setTipo(rs.getString("Tipo"));
                p.setPrecio(rs.getFloat("Precio"));
                
                Productos.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return Productos;
    }
    
}

}
