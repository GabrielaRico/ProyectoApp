package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DomicilioEntregaDAO {
	public boolean Actualizar(Object o) {
        boolean b = false;
        DomicilioEntrega dom = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update DomicilioEntrega set idDomicilioEntrega = ?, calle = ?,numeroint = ?,numeroext = ?,colonia = ?,delegacion = ? where idOrden = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            dom = (DomicilioEntrega) o;
            ps.setLong(1, dom.getIdDomicilioEntrega());
            ps.setString(2, dom.getCalle());
            ps.setLong(3, dom.getNumeroint());
            ps.setLong(4,dom.getNumeroext());
            ps.setString(5,dom.getColonia());
            ps.setString(4,dom.getDelegacion());


            
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
        DomicilioEntrega dom = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into DomicilioEntrega (idDomicilioEntrega,calle,numeroint,numeroext,colonia,delegacion) "
        		+ "values(?,?,?,?,?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            dom = (DomicilioEntrega) o;
            ps.setLong(1, dom.getIdDomicilioEntrega());
            ps.setString(2, dom.getCalle());
            ps.setLong(3, dom.getNumeroint());
            ps.setLong(4,dom.getNumeroext());
            ps.setString(5,dom.getColonia());
            ps.setString(4,dom.getDelegacion());

            
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
        DomicilioEntrega dom = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "delete from DomicilioEntrega where idDomicilioEntrega = ?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            dom = (DomicilioEntrega) o;
            ps.setLong(1,dom.getIdDomicilioEntrega());
            
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
 
    public ArrayList<DomicilioEntrega> Consulta(String descripcion) {
        ArrayList<DomicilioEntrega> DomicilioEntrega = null;
        String sql = "select * from DomicilioEntrega where descripcion like ('%"+descripcion+"%')";
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            DomicilioEntrega = new ArrayList<DomicilioEntrega>();
            
            while(rs.next())
            {
            	DomicilioEntrega dom = new DomicilioEntrega();
            		dom.setIdDomicilioEntrega(rs.getLong("idDomicilioEntrega"));
            		dom.setCalle(rs.getString("calle"));
            		dom.setNumeroint(rs.getLong("numeroint"));
            		dom.setNumeroext(rs.getLong("numeroext"));
            		dom.setDelegacion(rs.getString("colonia"));
            		dom.setColonia(rs.getString("delegacion"));
                
              

                DomicilioEntrega.add(dom);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return DomicilioEntrega;
    }

}
