<%-- 
    Document   : administradorPrincipal
    Created on : Jul 28, 2015, 1:06:30 PM
    Author     : luisito
    Pruebas de envio2 34

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/Kendo/kendo.common.min.css" />
        <link rel="stylesheet" href="../css/Kendo/kendo.default.min.css">
        
        <link href="../css/bootstrap/styles.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/Kendo/kendo.all.min.js"></script>
     <script>
            var tipoConsulta="";
                        
            function cargaInicial(tipoConsulta){
                $.ajax({
                    url: '../Administrador_Controller',
                    data: {
                        "tipoConsulta": tipoConsulta
                    },
                    async: true,
                    type: 'POST',
                    datatype: 'json',
                    success: function (data) {
                         var listadoTipos = data.listadoTipos;
                         var selogro=data.success;
                         if(selogro===true){
                             
                                $.each(listadoTipos, function (index) {

                                     $("#dataTable").append("<tr>" +
                                     "<td style='width: 10%'><a onclick='redirecciona();'>" + listadoTipos[index].tipo + "</a></td>" +
                                     "<td style='width: 10%'>" + listadoTipos[index].nemotecnico + "</td>" +
                                     "</tr>");
                                 });
                             }else{
                                 alert ("no existe nada en la BD");
                             }
                    }
                });
            }
            
           $(document).ready(function () {
               tipoConsulta="TodosTipos"
               cargaInicial(tipoConsulta);
               $('#Contenidos').hide();
               
               $("#guardar").click(function () {
                        var operacion="insertar";
                        var idTipoPalabra="";
                        var nombrePalabra=$("#tipoPalabra").val();
                        var nemotecnico=$("#nemotecnico").val();
                        
                        Procesos(operacion,idTipoPalabra,nombrePalabra,nemotecnico);
                   });
                
               
            });
            
            function redirecciona(){
                
                $('#TablaTodos').hide();
                $('#Contenidos').show();
                $('#nuevo').hide();
                
                
            }
            
            function Procesos(operacion,idTipoPalabra, nombrePalabra,nemotecnico){
                $.ajax({
                    url: '../Administrador_Controller',
                    data: {
                        "operacion": operacion,
                        "idTipoPalabra":idTipoPalabra,
                        "nombrePalabra":nombrePalabra,
                        "nemotecnico":nemotecnico
                    },
                    async: true,
                    type: 'POST',
                    datatype: 'json',
                    success: function (data) {
                         var selogro=data.success;
                         var mensaje=data.mensaje;
                          if(selogro===true){
                                    alert ("GRABADO EXITOSO");
                              }else{
                                 alert ("GRABADO INCORRECTO ERROR:"+mensaje);
                             }
                          
                    }
                });
            }
            
        </script>
    </head>
    <body>
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
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about.html">Inicio</a>
                    </li>
                    <li>
                        <a href="services.html">Nosotros</a>
                    </li>
                    <li>
                        <a href="contact.html">Administrador</a>
                    </li>
                    
                </ul>
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
                <ol class="breadcrumb">
                    <li><a href="index.html">Inicio</a>
                    </li>
                    <li class="active">Administración</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
        <!-- Content Row -->
        <div class="row">
            <!-- Sidebar Column -->
            <div class="col-md-3">
                <div class="list-group">
                    <a href="index.html" class="list-group-item active">Tipos Palabras</a>
                    <a href="about.html" class="list-group-item">Tiempos</a>
                    <a href="services.html" class="list-group-item">Palabras</a>
                </div>
            </div>
            <!-- Content Column -->
            <div class="col-md-9">
                <h2>Tipos de Palabras</h2>
                <p>Los tipos de palabras son distintivos básicos de cada palabra, estas pueden ser adjetivos, advervios,
                    sustantivos, verbos entre otras, esto ayudará a mejorar la traducción</p>
                
                <br>
                <div align="right">
                    <button id="nuevo" type="button" class="btn btn-default" onclick="redirecciona();">Nuevo</button>
                </div>
                <br>
                <div id="TablaTodos" class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <td style='width: 50%'>Tipo de Palabra</td>
                                <td style='width: 50%'>Nombre Nemotecnico</td>
                            </tr>
                        </thead>
                        <tbody id="dataTable">
                        </tbody>
                                
                    </table>
                    </div>
                    <div class="col-md-3"></div>
                    
                </div>
                <div id="Contenidos" class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form class="form-horizontal">
                                <div class="form-group">
                                  <label for="tipoPalabra" class="col-sm-6 control-label">TIPO DE PALABRA</label>
                                  <div class="col-sm-6">
                                    <input type="text" class="form-control" id="tipoPalabra" placeholder="Sujeto,Verbo,etc ">
                                  </div>
                                </div>
                                <div class="form-group">
                                  <label for="nemotecnico" class="col-sm-6 control-label">NEMOTÉCNICO</label>
                                  <div class="col-sm-6">
                                    <input type="text" class="form-control" id="nemotecnico" placeholder="SUJ,VER,etc">
                                  </div>
                                </div>
                                
                                <div class="form-group">
                                  <div class="col-sm-offset-6 col-sm-10">
                                    <button type="submit" id="guardar" class="btn btn-default">Guardar</button>
                                  </div>
                                </div>
                              </form>
                                
                    </table>
                    </div>
                    <div class="col-md-3"></div>
                    
                </div>   


        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->
    </body>
</html>
