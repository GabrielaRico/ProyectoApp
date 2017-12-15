<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.ArrayList"
    	import = "DAO.*"
    	import = "java.sql.*"%>
<% ArrayList<Orden> ontime = null;
	ArrayList<Orden> pastdue = null;
	
%>
<%
	String sql = "select * from Orden where fechaEntrega < getDate() ";
	String sql2 = "select * from Orden where fechaEntrega > getDate() ";
	String nombre = "";
try
{
    Datasource d = new Datasource("clariantbd.database.windows.net","3306","clariantbd","gaby","alki1380");
    Connection c = d.getConexion();
    Statement s = c.createStatement();
    ResultSet rs = s.executeQuery(sql);
    ontime = new ArrayList<Orden>();
    
    while(rs.next())
    {
        Orden or = new Orden();
        or.setIdOrden(rs.getInt("idOrden"));
        or.setFechaEntrega(rs.getDate("fechaEntrega"));
        int idProv = rs.getInt("idProveedor");
        String id = "select descripcion from Proveedor where idProveedor ="+idProv;
        Statement sid = c.createStatement();
        ResultSet RSid = sid.executeQuery(id);
        if(rs.next())
        	nombre = RSid.getString("descripcion");
		or.setProveedor(nombre);
        ontime.add(or);
    }
    Statement sq = c.createStatement();
    ResultSet rsq = sq.executeQuery(sql);
    pastdue = new ArrayList<Orden>();
    
    while(rsq.next())
    {
    	Orden or = new Orden();
        or.setIdOrden(rs.getInt("idOrden"));
        or.setFechaEntrega(rs.getDate("fechaEntrega"));
        int idProv = rs.getInt("idProveedor");
        String id = "select descripcion from Proveedor where idProveedor ="+idProv;
        Statement sid = c.createStatement();
        ResultSet RSid = sid.executeQuery(id);
        if(rs.next())
        	nombre = RSid.getString("descripcion");
		or.setProveedor(nombre);

        pastdue.add(or);	
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" 
crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
 integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" 
 crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
 integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" 
 crossorigin="anonymous"></script> 
 
<title> Control Manager </title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#"> Control Manager </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
          <li class="nav-item">
            <a class="nav-link disabled" href="PaginaPrincipal.jsp">  Home </a>
          </li>
            <a class="nav-link" href="Productos.jsp">  Productos <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Proveedores.jsp">  Proveedores </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Ordenes.jsp">  Ordenes  </a>
          </li>
        
        </ul>
      </div>
    </nav>
    
<br>
<br>
<br>

<h2>Ordenes Pendientes</h2>

<div class="row">
	<div class="col-md-4">
    <table class="table"> 
     <tr class="table-success"> 
       <th scope="col"> idOrden </th>
      <th scope="col"> Fecha Entrega </th>
      <th scope="col"> Proveedor </th>
     </tr> 
   </thead>
   <tbody> 
  <% 
 if (ontime != null){
  	for (Orden o: ontime){ %>
    <a href="UpdateProductos.jsp/<%=o.getIdOrden()%>">
    <tr>
 		<td><%=o.getIdOrden() %></td>
 		<td><%=o.getFechaEntrega() %></td>
 		<td><%=o.getProveedor() %></td>
    </tr> 
    </a> 
 <% }} %>

  </tbody> 
 </table> 
 </div>
</div>

    <h2>Ordenes Atrasadas</h2>
    <div class="row">
	<div class="col-md-4">
    <table class="table"> 
     <tr class="table-danger"> 
       <th scope="col"> idOrden </th>
      <th scope="col"> Fecha Entrega </th>
      <th scope="col"> Proveedor </th>
     </tr> 
   </thead>
   <tbody> 
  <% 
 if (pastdue != null){
  	for (Orden o: pastdue){ %>
    <a href="UpdateProductos.jsp/<%=o.getIdOrden()%>">
    <tr>
 		<td><%=o.getIdOrden() %></td>
 		<td><%=o.getFechaEntrega() %></td>
 		<td><%=o.getProveedor() %></td>
    </tr> 
    </a> 
 <% }} %>

  </tbody> 
 </table> 
 </div>
</div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../../../../dist/js/bootstrap.min.js"></script>
</div>



</body>
</html>