package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdenDAO implements DAO{
	public boolean Actualizar(Object o) {
        boolean b = false;
        Orden or = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update Orden set idOrden = ?, fechaCreacion = ?, fechaEntrega = ?, "
        		+ "descripcionArticulo = ?,precioUnitario = ?, numeroPiezas = ?, total = ?,"
        		+ " status = ?, correoEnviado = ? where idOrden = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            or = (Orden) o;
            ps.setLong(1, or.getIdOrden());
            ps.setDate(2, or.getFechaCreacion());
            ps.setDate(3, or.getFechaEntrega());
            ps.setString(4, or.getDescripcionArticulo());
            ps.setFloat(5, or.getPrecioUnitrario());
            ps.setInt(6, or.getNumeroPiezas());
            ps.setFloat(7, or.getTotal());
            ps.setInt(8, or.getStatus());
            ps.setInt(9, or.getCorreoEnviado());

            
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
        Orden or = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into Orden (idOrden,fechaCreacion,fechaEntrega,descripcionArticulo,precioUnitario,numeroPiezas,total,status correoEnviado) "
        		+ "values(?,?,?,?,?,?,?,?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            or = (Orden) o;
            ps.setLong(1, or.getIdOrden());
            ps.setDate(2, or.getFechaCreacion());
            ps.setDate(3, or.getFechaEntrega());
            ps.setString(4, or.getDescripcionArticulo());
            ps.setFloat(5, or.getPrecioUnitrario());
            ps.setInt(6, or.getNumeroPiezas());
            ps.setFloat(7, or.getTotal());
            ps.setInt(8, or.getStatus());
            ps.setInt(9, or.getCorreoEnviado());
            
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
        Orden or = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "delete from Orden where idOrden = ?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            or = (Orden) o;
            ps.setLong(1,or.getIdOrden());
            
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
 
    public ArrayList<Orden> Consulta(String descripcion) {
        ArrayList<Orden> Orden = null;
        String sql = "select * from Orden where descripcion like ('%"+descripcion+"%')";
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            Orden = new ArrayList<Orden>();
            
            while(rs.next())
            {
                Orden or = new Orden();
                or.setIdOrden(rs.getInt("idOrden"));
                or.setDescripcionArticulo(rs.getString("descripcionArticulo"));
                or.setPrecioUnitrario(rs.getFloat("precioUnitario"));
                or.setNumeroPiezas(rs.getInt("numeroPiezas"));
                or.setTotal(rs.getFloat("total"));
                or.setStatus(rs.getInt("status"));
                or.setCorreoEnviado(rs.getInt("correoEnviado"));

                Orden.add(or);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return Orden;
    }
    
}


