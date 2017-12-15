package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ComprasAlmacenDAO implements DAO{
	public boolean Actualizar(Object o) {
        boolean b = false;
        ComprasAlmacen ca = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update ComprasAlmacen set idCompras = ?, Descripcion = ?, where idCompras = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            ca = (ComprasAlmacen) o;
            ps.setLong(1, ca.getIdCompras());
            ps.setString(2, ca.getDescripcion());
 
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
        ComprasAlmacen ca = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into ComprasAlmacen (idCompras,Descripcion) values(?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            ca = (ComprasAlmacen) o;
            ps.setFloat(1, ca.getIdCompras());
            ps.setString(2, ca.getDescripcion());

            
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
        ComprasAlmacen ca = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into ComprasAlmacen (idCompras,Descripcion) values(?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            ca = (ComprasAlmacen) o;
            ps.setFloat(1,ca.getIdCompras());
            
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

    
    public ArrayList<ComprasAlmacen> Consulta(String descripcion) {
        ArrayList<ComprasAlmacen> compras = null;
        String sql = "select * from ComprasAlmacen where Descripcion like ('%"+descripcion+"%')";
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            compras = new ArrayList<ComprasAlmacen>();
            
            while(rs.next())
            {
                ComprasAlmacen p = new ComprasAlmacen();
                p.setIdCompras(rs.getLong("idCompras"));
                p.setDescripcion(rs.getString("Descripcion"));
                
                
                compras.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return compras;
    }
    
}

