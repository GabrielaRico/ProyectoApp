package DAO;
import java.util.ArrayList;
import java.sql.*;

public class ProductosDAO implements DAO{


    
    public boolean Actualizar(Object o) {
        boolean b = false;
        Productos p = null;
        Datasource d = new Datasource("clariantbd.database.windows.net","3306","clariantbd","gaby","Alki1380");
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

    
    public ArrayList<Productos> Consulta(String descripcion) {
        ArrayList<Productos> productos = null;
        String sql = "select * from Productos where descripcion like ('%"+descripcion+"%')";
        try
        {
        		Datasource d = new Datasource("clariantbd.database.windows.net","3306","clariantbd","gaby","Alki1380");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            productos = new ArrayList<Productos>();
            
            while(rs.next())
            {
                Productos p = new Productos();
                p.setIdProductos(rs.getInt("idProductos"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setTipo(rs.getString("Tipo"));
                p.setPrecio(rs.getFloat("Precio"));
                
                productos.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return productos;
    }
    
}
