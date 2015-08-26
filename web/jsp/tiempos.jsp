<%-- 
    Document   : tiempos
    Created on : Aug 20, 2015, 1:27:59 PM
    Author     : luisito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiempos</title>
        <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/Kendo/kendo.common.min.css" />
        <link rel="stylesheet" href="../css/Kendo/kendo.default.min.css">
        <link href="../css/bootstrap/styles.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/Kendo/kendo.all.min.js"></script>
        <script>
            var tipoConsulta="";
            
            $(document).ready(function () {
                 
                
               tipoConsulta="TodosTipos";
               cargaInicial(tipoConsulta);
               
               $('#Contenidos').hide();
               
               $("#guardar").click(function () {
                        
                       
                        var idTiempo=$("#idTiempo").val();
                        var tiempo=$("#tiempo").val();
                        var nemotecnico=$("#nemotecnico").val();
                        if(tiempo==="" || nemotecnico==="" ){
                            if(tiempo===""){
                                alert("Por favor ingrese el Tiempo");
                           }
                           if(nemotecnico===""){
                                alert("Por favor ingrese el Nemoténico");
                           } 
                            
                        }else{
                            if(idTiempo===""){
                                var operacion="insertar";
                                Procesos(operacion,idTiempo,tiempo,nemotecnico);
                                tipoConsulta="TodosTipos";
                                location.reload();
                                //cargaInicial(tipoConsulta);
                            }else{
                                var operacion="actualizar";
                                Procesos(operacion,idTiempo,tiempo,nemotecnico);
                                tipoConsulta="TodosTipos";
                                location.reload();
                                //cargaInicial(tipoConsulta);
                            }
                            
                        }
                        
                   });
                
               
            });
                        
            function cargaInicial(tipoConsulta){
                //DE KENDO
        
                
                //FIN KENDO
                $("#idTiempo").val("");
                $('#Contenidos').hide();
                $('#TablaTodos').show();
                $('#nuevo').show();
                $("#tiempo").val("");
                $("#nemotecnico").val("");
                $.ajax({
                    url: '../Tiempos_Controller',
                    data: {
                        "tipoConsulta": tipoConsulta
                    },
                    async: false,
                    type: 'POST',
                    datatype: 'json',
                    success: function (data) {
                         var listadoTipos = data.listadoTiempos;
                         var selogro=data.success;
                         if(selogro===true){
                                $("#dataTable").children().remove();
                                $.each(listadoTipos, function (index) {

                                     $("#dataTable").append("<tr>" +
                                     "<td style='width: 10%'><a onclick='redireccionaActualizar(&#39;"+listadoTipos[index].id+"&#39;,&#39;"+listadoTipos[index].tiempo+"&#39;,&#39;"+listadoTipos[index].nemotecnico+"&#39;);'>" + listadoTipos[index].tiempo + "</a></td>" +
                                     "<td style='width: 10%'>" + listadoTipos[index].nemotecnico + "</td>" +
                                     "</tr>");
                                 });
                             }else{
                                 alert ("no existe nada en la BD");
                             }
                    }
                });
                $("#gridInfo").kendoGrid({
                        height: 500,
                        filterable: true,
                        sortable: true,
                        scrollable: true,
//                        pageable: {
//                            input: true,
//                            numeric: true,
//                            pageSize: 20
//                        },
                        navigatable: true
                       
                });
            }
            
            function redireccionaInsertar(){
                
                $('#TablaTodos').hide();
                $('#Contenidos').show();
                $('#nuevo').hide();
                $("#guardar").text("GUARDAR");
                $('#eliminar').hide();    
            
            }
            
            function redireccionaActualizar(id, nombre, nemotecnico){
                
                $('#TablaTodos').hide();
                $('#Contenidos').show();
                $('#nuevo').hide();
                $('#eliminar').show();
                if(id!==""){
                    $("#guardar").text("ACTUALIZAR");
                    $("#tiempo").val(nombre);
                    $("#nemotecnico").val(nemotecnico);
                    $("#idTiempo").val(id);
                    
                    //Procesos("ACTUALIZAR",id, nombrePalabra,nemotecnico);
                    
                }
            
            }
            
            function eliminarRegistro(){
                
               var seguro = confirm("Esta seguro que desea borrar el tiempo?");
                if (seguro == true) {
                    var operacion="eliminar";
                    var idTipoPalabra=$("#idTiempo").val();
                    var nombrePalabra="";
                    var nemotecnico="";
                    Procesos(operacion,idTipoPalabra, nombrePalabra,nemotecnico);
                    var tipoConsulta="TodosTipos";
                    location.reload();
                    //cargaInicial(tipoConsulta);
                } 
                
            }
            
            function Procesos(operacion,idTiempo, tiempo,nemotecnico){
                
                $.ajax({
                    url: '../Tiempos_Controller',
                    data: {
                        "operacion": operacion,
                        "idTiempo":idTiempo,
                        "tiempo":tiempo,
                        "nemotecnico":nemotecnico
                    },
                    async: false,
                    type: 'POST',
                    datatype: 'json',
                    success: function (data) {
                         var selogro=data.success;
                         var mensaje=data.mensaje;
                          if(selogro===true){
                                    alert (""+mensaje);
                              }else{
                                 alert ("PROCESO INCORRECTO ERROR:"+mensaje);
                             }
                          
                    }
                    
                });
                
            }
            
            function cerrarSesion(){
            $.ajax({
                url : '../Salir',      				
                type : 'POST',
                datatype : 'json',
                success : function(data) {   
                    if (data.success == true){
                            window.location= "../index.jsp";
                    }
                }
            });	                
         }
         
         function abreCambio(){
             var agente = window.open("cambioContrasenia.jsp","ventana1","directories=no,width=500,height=500,resizable=no,scrollbars=yes,top=0,left=260,status=1");
             agente.opener = self;
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
                <a class="navbar-brand" href="../index.html">KUTIPAK UTC</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="../index.html">Inicio</a>
                    </li>
                    <li>
                        <a href="../html/services.html">Nosotros</a>
                    </li>
                    <li>
                        <a href="../html/contact.html">Administrador</a>
                    </li>
                    <li>
                        <a onClick="cerrarSesion();" href="../index.html">Cerrar Seción</a>
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
                    <li><a href="../index.html">Inicio</a>
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
                    <a href="administradorPrincipal.jsp" class="list-group-item ">Tipos Palabras</a>
                    <a href="tiempos.jsp" class="list-group-item active">Tiempos</a>
                    <a href="palabras.jsp" class="list-group-item">Palabras</a>
                    <a  onClick="abreCambio();" class="list-group-item">Cambio de Contraseña</a>
                </div>
            </div>
            <!-- Content Column -->
            <div class="col-md-9">
                <h2>Tiempos</h2>
                <p>Los tiempos, son la forma en que se representa la oración y sus variantes a través del tiempo, estos son estándares por medio de los 
                    cuales se traducirá la palabra en base al tiempo, lo que mejorara la calidad de traducción</p>
                
                <br>
                <div align="right">
                    <button id="nuevo" type="button" class="btn btn-default" onclick="redireccionaInsertar();">Nuevo</button>
                </div>
                
                <div id="TablaTodos" class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <table class="table table-hover table-bordered" id="gridInfo">
                         <colgroup>
                                <col />
                                <col />
                        </colgroup>
                        <thead>
                            <tr>
                                <th >Tiempos</th>
                                <th >Nombre Nemotécnico</th>
                            </tr>
                        </thead>
                        <tbody id="dataTable">
                        </tbody>
                                
                    </table>
                    </div>
                    <div class="col-md-3"></div>
                    
                </div>
                <div id="Contenidos" class="row">
                    <div align="left">
                            <button id="regresar" type="button" class="btn btn-default" onclick="javascript:location.reload();">Regresar</button>
                        </div>
                    <div align="right">
                            <button id="eliminar" type="button" class="btn btn-danger" onclick="eliminarRegistro();">Eliminar</button>
                    </div>
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <br>
                        <form class="form-horizontal">
                                <div class="form-group">
                                  <label for="tiempo" class="col-sm-6 control-label">TIEMPO</label>
                                  <div class="col-sm-6">
                                    <input type="text" class="form-control" id="tiempo" placeholder="Presente, Pasado, etc ">
                                  </div>
                                </div>
                                <div class="form-group">
                                  <label for="nemotecnico" class="col-sm-6 control-label">NEMOTÉCNICO</label>
                                  <div class="col-sm-6">
                                    <input type="text" class="form-control" id="nemotecnico" placeholder="PRE, PAS">
                                    <input type="hidden" class="form-control" id="idTiempo">
                                  </div>
                                </div>
                                
                                <div class="form-group">
                                  <div class="col-sm-offset-6 col-sm-10">
                                    <button type="button" id="guardar" class="btn btn-primary">Guardar</button>
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
                    <p>Copyright &copy; Your Website 2015</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->
    </body>
</html>
