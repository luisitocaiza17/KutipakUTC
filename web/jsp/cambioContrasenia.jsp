<%-- 
    Document   : cambioContraseña
    Created on : Aug 19, 2015, 2:40:12 PM
    Author     : luisito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambio Contraseña</title>
        <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/Kendo/kendo.common.min.css" />
        <link rel="stylesheet" href="../css/Kendo/kendo.default.min.css">
        
        <link href="../css/bootstrap/styles.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/Kendo/kendo.all.min.js"></script>
        
        <script>
            function verificar(){
                var antigua =$('#contraseniaActual').val(); 
                var nueva =$('#contraseniaNueva').val(); 
                var repnueva =$('#repitaContraseniaNueva').val(); 
                
                if(antigua===""||nueva===""||repnueva===""){
                    alert("Todos los campos deben estar llenos");
                    return false;
                }else{
                    if(nueva !== repnueva){
                        alert("Las contraseñas nuevas no coinciden vuelva a ingresarlas por favor ");
                        return false;
                    }else{
                        return true;
                    }
                    
                }
            }
            
        </script>
    </head>
    <body>
          
    <%// Permitimos el acceso si la session existe		
         if(session.getAttribute("usuario") == null){
             response.sendRedirect("../index.html");
         }
     %>
             <!-- Navigation -->
     <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
         <div class="container">
             <!-- Brand and toggle get grouped for better mobile display -->
             <div class="navbar-header">
                 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                     <span class="sr-only">Toggle navigation</span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                 </button>
                 <a class="navbar-brand" href="index.html">KUTIPAK UTC</a>
             </div>
             <!-- Collect the nav links, forms, and other content for toggling -->
             <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                 
             </div>
             <!-- /.navbar-collapse -->
         </div>
         <!-- /.container -->
     </nav>
             <br>
             <br>
             <!-- Page Content -->
     <div class="container">

         <!-- Page Heading/Breadcrumbs -->
         <div class="row">
             <div class="col-lg-12">
                 <h2 class="page-header">Administración de KUTIPAK UTC
                     <small>'Mejorando cada día'</small>
                 </h2>
                 
             </div>
         </div>
          <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form class="form-horizontal" method="POST" ACTION="../Contrasenia_Controller" onsubmit="return verificar();" >
                            <div class="form-group">
                              <label for="inputEmail3" class="col-sm-2 control-label">CONTRASEÑA ACTUAL:</label>
                              <div class="col-sm-4">
                                <input type="password" class="form-control" name="contraseniaActual" id="contraseniaActual" placeholder="Antigua">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="inputPassword3" class="col-sm-2 control-label">CONTRASEÑA NUEVA</label>
                              <div class="col-sm-4">
                                <input type="TEXT" class="form-control" name="contraseniaNueva" id="contraseniaNueva" placeholder="Nueva">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="inputPassword3" class="col-sm-2 control-label">REPITA CONTRASEÑA NUEVA</label>
                              <div class="col-sm-4">
                                <input type="password" class="form-control" name="repitaContraseniaNueva" id="repitaContraseniaNueva" placeholder="Repetir Nueva">
                              </div>
                            </div>
                            
                            <div class="form-group">
                              <div class="col-sm-offset-2 col-sm-4">
                                <button type="submit" class="btn btn-primary">.GUARDAR.</button>
                                <button onclick="window.close();" href="" class="btn btn-info">REGRESAR</button>
                              </div>
                            </div>
                          </form>
                        
                    </div>
                    <div class="col-md-3"></div>

          </div>
     </div>
     
     </body>
</html>
