package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO implements DAO{
	public boolean Actualizar(Object o) {
        boolean b = false;
        Usuario u = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "update Orden set idOrden = ?, fechaCreacion = ?, fechaEntrega = ?, "
        		+ "descripcionArticulo = ?,precioUnitario = ?, numeroPiezas = ?, total = ?,"
        		+ " status = ?, correoEnviado = ? where idOrden = ?";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(sql);
            u = (Usuario) o;
            ps.setLong(1, u.getIdUsuario());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getEmail());
            ps.setLong(4, u.getTelefonoLocal());

            
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
        Usuario u = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "insert into Orden (idUsuario,nombre,email,telefonoLocal) "
        		+ "values(?,?,?,?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            u = (Usuario) o;
            ps.setLong(1, u.getIdUsuario());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getEmail());
            ps.setLong(4, u.getTelefonoLocal());
            
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
        Usuario u = null;
        Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
        Connection c = d.getConexion();
        String sql = "delete from Usuario where idUsuario = ?)";
        
        try
        {
            
            PreparedStatement ps = c.prepareStatement(sql);
            u = (Usuario) o;
            ps.setLong(1,u.getIdUsuario());
            
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
 
    public ArrayList<Usuario> Consulta(String descripcion) {
        ArrayList<Usuario> Usuario = null;
        String sql = "select * from Usuario where descripcion like ('%"+descripcion+"%')";
        try
        {
            Datasource d = new Datasource("localhost","3306","CLARIANTBD","gabyclariant","rico");
            Connection c = d.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            Usuario = new ArrayList<Usuario>();
            
            while(rs.next())
            {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setTelefonoLocal(rs.getLong("telefonoLocal"));
            

                Usuario.add(u);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return Usuario;
    }
    
}