package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Datasource {
	 private String hostname;
	    private String puerto;
	    private String usuario;
	    private String password;
	    private String bd;
	       
	public Datasource(String hostname, String puerto, String usuario, String password, String bd){
	    this.hostname="clariantbd.database.windows.net";
	    this.usuario="gaby";
	    this.password="Alki1380";
	    this.bd="clariantbd";
	    
	}
	public Connection getConexion(){
	    
	    Connection c=null;
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostname, bd, usuario, password);

	    try{
	        Class.forName("com.sqlserver.jdbc.Driver");
	        c=DriverManager.getConnection(url);
	        }
	    catch(Exception e){
	        e.printStackTrace();
	        }
	    return c;
	    }
	}

