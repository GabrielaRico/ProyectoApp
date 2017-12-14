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
	    this.hostname=hostname;
	    this.puerto=puerto;
	    this.usuario=usuario;
	    this.password=password;
	    this.bd=bd;
	    
	    
	}
	public Connection getConexion(){
	    
	    Connection c=null;
	    try{
	        Class.forName("com.sqlserver.jdbc.Driver");
	        c=DriverManager.getConnection("jdbc:mysql://"+hostname+":"+puerto+"/"+bd,usuario,password);
	        }
	    catch(Exception e){
	        e.printStackTrace();
	        }
	    return c;
	    }
	}

