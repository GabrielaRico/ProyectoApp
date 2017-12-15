package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RFCDAO {
	public boolean Actualizar(Object o) {
        boolean b = false;
        RFC rfc = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update Orden set idRFC = ?,razonSocial = ? where irdRFC = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            rfc = (RFC) o;
            ps.setLong(1, rfc.getIdRFC());
            ps.setString(2, rfc.getRazonSocial());
            

            
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
        RFC rfc = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into Orden (idRazonSocial,razonSocial) "
        		+ "values(?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            rfc = (RFC) o;
            ps.setLong(1,rfc.getIdRFC());
            ps.setString(2, rfc.getRazonSocial());
            
            
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
        RFC rfc = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "delete from RFc where idRFC = ?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            rfc = (RFC) o;
            ps.setLong(1,rfc.getIdRFC());
            
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
 
    public ArrayList<RFC> Consulta(String descripcion) {
        ArrayList<RFC> rfc = null;
        String sql = "select * from RFC where descripcion like ('%"+descripcion+"%')";
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rfc = new ArrayList<RFC>();
            
            while(rs.next())
            {
            	   RFC or = new RFC();
            	   or.setIdRFC(rs.getLong("idRFC"));
            	   or.setRazonSocial(rs.getString("descripcionArticulo"));
                

                rfc.add(or);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return rfc;
    }
    
}



