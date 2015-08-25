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
        <title>Palabras</title>
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
                
                var data = [
                            "Albania",
                            "Andorra",
                            "Armenia",
                            "Austria",
                            "Azerbaijan",
                            "Belarus",
                            "Belgium",
                            "Bosnia & Herzegovina",
                            "Bulgaria",
                            "Croatia",
                            "Cyprus",
                            "Czech Republic",
                            "Denmark",
                            "Estonia",
                            "Finland",
                            "France",
                            "Georgia",
                            "Germany",
                            "Greece",
                            "Hungary",
                            "Iceland",
                            "Ireland",
                            "Italy",
                            "Kosovo",
                            "Latvia",
                            "Liechtenstein",
                            "Lithuania",
                            "Luxembourg",
                            "Macedonia",
                            "Malta",
                            "Moldova",
                            "Monaco",
                            "Montenegro",
                            "Netherlands",
                            "Norway",
                            "Poland",
                            "Portugal",
                            "Romania",
                            "Russia",
                            "San Marino",
                            "Serbia",
                            "Slovakia",
                            "Slovenia",
                            "Spain",
                            "Sweden",
                            "Switzerland",
                            "Turkey",
                            "Ukraine",
                            "United Kingdom",
                            "Vatican City"
                        ];
                        
                        $("#traduccion").kendoAutoComplete({
                        dataSource: data,
                        filter: "startswith",
                        placeholder: "Select country...",
                        separator: ", "
                    });
                
                
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
                                cargaInicial(tipoConsulta);
                            }else{
                                var operacion="actualizar";
                                Procesos(operacion,idTiempo,tiempo,nemotecnico);
                                tipoConsulta="TodosTipos";
                                cargaInicial(tipoConsulta);
                            }
                            
                        }
                        
                   });
                
               
            });
                        
            function cargaInicial(tipoConsulta){
                $("#idTiempo").val("");
                $('#Contenidos').hide();
                $('#TablaTodos').show();
                $('#nuevo').show();
                $("#tiempo").val("");
                $("#nemotecnico").val("");
                $.ajax({
                    url: '../Palabras_Controller',
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
                    cargaInicial(tipoConsulta);
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
        
        
        
            <script>
                
//                http://demos.telerik.com/kendo-ui/grid/from-table
                $(document).ready(function () {
                    $("#grid").kendoGrid({
                        dataSource: {
                            type: "odata",
                            transport: {
                                read: "//demos.telerik.com/kendo-ui/service/Northwind.svc/Customers"
                            },
                            pageSize: 20
                        },
                        height: 550,
                        groupable: true,
                        sortable: true,
                        pageable: {
                            refresh: true,
                            pageSizes: true,
                            buttonCount: 5
                        },
                        columns: [{
                            
                            field: "Palabra",
                            title: "Palabra",
                            
                        }, {
                            field: "Traduccion",
                            title: "Traduccion"
                        }, {
                            field: "Idioma",
                            title: "Idioma"
                        }, {
                            field: "Tipo",
                            title: "Tipo"
                        }]
                    });
                });
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
            <!-- Collect the nav links, forms, and other content for toggling   -->
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
                    <a href="tiempos.jsp" class="list-group-item ">Tiempos</a>
                    <a href="palabras.jsp" class="list-group-item active">Palabras</a>
                    <a  onClick="abreCambio();" class="list-group-item">Cambio de Contraseña</a>
                </div>
            </div>
            <!-- Content Column -->
            <div class="col-md-9">
                <h2>Palabras</h2>
                <p>En la sección palabras, usted puede ingresar palabras al diccionario de Kutipak UTC, tanto la palabra como 
                su significado se almacenaran en la base de datos para poder mostrar la misma en la base de datos</p>
                
                <br>
                <div align="right">
                    <button id="nuevo" type="button" class="btn btn-default" onclick="redireccionaInsertar();">Nuevo</button>
                </div>
                
                <div id="TablaTodos" class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                                               
<!--                        <div id="grid"></div>-->
                        
                        
                        
                        <kendo:grid name="products" pageable="true">
                            <kendo:dataSource pageSize="10" serverPaging="true">
                                    <kendo:dataSource-transport read="../Palabras_Controller">
                                            <kendo:dataSource-transport-parameterMap>
                                                    <script>
                                                            function parameterMap() {
                                                                    return {
                                                                        tipoConsulta: "TodosTipos"                                                                         
                                                                    };
                                                            }
                                                    </script>
                                            </kendo:dataSource-transport-parameterMap>
                                    </kendo:dataSource-transport>
                                    <kendo:dataSource-schema data="Data" total="Total"></kendo:dataSource-schema>
                            </kendo:dataSource>
                            <kendo:grid-columns>
                                    <kendo:grid-column title="TIEMPOSID" field="TIEMPOSID" />
                                    <kendo:grid-column title="NOMBRETIEMPO" field="NOMBRETIEMPO" />
                                    <kendo:grid-column title="NEMOTECNICOTIEMPO" field="NEMOTECNICOTIEMPO" />
                                    
                            </kendo:grid-columns>
                    </kendo:grid>

                        
                        
                        
                    </div>
                    <div class="col-md-2"></div>
                    
                    
                </div>
                <div id="Contenidos" class="row">
                    <div align="left">
                            <button id="regresar" type="button" class="btn btn-default" onclick="cargaInicial('TodosTipos');">Regresar</button>
                        </div>
                    <div align="right">
                            <button id="eliminar" type="button" class="btn btn-danger" onclick="eliminarRegistro();">Eliminar</button>
                    </div>
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <br>
                        <form class="form-horizontal">
                                <div class="form-group">
                                  <label for="palabra" class="col-sm-6 control-label">Palabra</label>
                                  <div class="col-sm-6">
                                    <input type="text" class="form-control" id="palabra" placeholder="auto,casa">
                                  </div>
                                </div>
                                <div class="form-group">
                                  <label for="idioma" class="col-sm-6 control-label">Idioma</label>
                                  <div class="col-sm-6">
                                    <select class="form-control required" id="idioma"> 
                                        <option value='1'>Español</option>
                                        <option value='2'>kitchwa</option>
                                    </select>
                                  </div>
                                </div>
                            
                                <div class="form-group">
                                  <label for="tipo" class="col-sm-6 control-label">Tipo</label>
                                  <div class="col-sm-6">
                                    <select class="form-control required" id="tipo"> 
                                        <option value='1'>Español</option>
                                        <option value='2'>kitchwa</option>
                                    </select>
                                  </div>
                                </div>
                            
                                <div class="form-group">
                                  <label for="eltiempo" class="col-sm-6 control-label">Tiempo</label>
                                  <div class="col-sm-6">
                                    <select class="form-control required" id="eltiempo"> 
                                        <option value='1'>Español</option>
                                        <option value='2'>kitchwa</option>
                                    </select>
                                  </div>
                                </div>
                                 
                                <div class="form-group">
                                  <label for="traduccion" class="col-sm-6 control-label">Traducción</label>
                                  <div class="col-sm-6">
                                    <div class="demo-section k-header"> 
                                        <input id="traduccion" style="width: 100%;" />
                                    </div>
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
