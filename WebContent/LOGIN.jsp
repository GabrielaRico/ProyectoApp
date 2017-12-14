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

<title>   CONTROL MANAGER </title>
</head>
<body>
<div class="container">
<div class="p-3 mb-2 bg-info text-white">.bg-info</div>
      <form class="form-signin" method="POST" action="/control">
        <h2 class="form-signin-heading"> INICIO DE SESION </h2>
        <label  class="sr-only"> Nombre de Usuario</label>
        <input  id="inputUser" name = "usuario" class="form-control" placeholder="Ingrese usuario" required autofocus>
        <label for="inputPassword" class="sr-only"> Contraseña </label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Ingrese contraseña" required>
        <div class="checkbox">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">  Aceptar </button>
      </form>

    </div> <!-- /container -->


</body>

</html>