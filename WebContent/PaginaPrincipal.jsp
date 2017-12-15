<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="row">
	<div class="col-md-4">
    <table class="table"> 
     <tr class="table-danger"> 
       <th scope="col"> idProducto </th> 
       <th scope="col"> Descripcion </th> 
       <th scope="col"> Tipo </th> 
       <th scope="col"> Precio </th>
     </tr> 
   </thead>
   <tbody> 
  <% 
 if (productos != null){
  	for (Productos p: productos){ %>
    <a href="UpdateProductos.jsp/<%=p.getIdProductos()%>">
    <tr>
 		<td><%=p.getIdProductos() %></td>
 		<td><%=p.getDescripcion() %></td>
 		<td><%=p.getTipo() %></td>
 		<td><%=p.getPrecio() %></td>
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