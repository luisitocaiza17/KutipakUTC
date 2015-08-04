<%-- 
    Document   : index
    Created on : Jul 11, 2015, 5:13:16 PM
    Author     : luisito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/bootstrap/styles.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script>
            var usuario = "";
            var contrasenia = "";
            $(document).ready(function () {
                $("#entrar").bind({click: function () {
                    usuario=$('#usuario').val();
                    contrasenia=$('#contrasenia').val(); 
                   
                    verificar(usuario,contrasenia);
                }
            })
            });
            
//            function verificar(usuario1,contrasenia1){
//                $.ajax({
//                url: '../Login_Controller',
//                data: {
//                    "usuario": usuario1,
//                    "contrasenia": contrasenia1
//                },
//                async: true,
//                type: 'POST',
//                datatype: 'jsonp',
//                success: function (data) {
//                     if(data.success===true){
//                            alert("EXITO")
//                    }else{
//                                alert("EL USUARIO NO EXISTE, VUELVA A INTENTARLO")
//                                return false;
//                            }
//                    
//                }
//            });
//            }
        </script>
        
    </head>
    <body>
        <div class="row">

            <div class="col-lg-12 text-center v-center">

                <h1>HOLA administrador!</h1>
                <p class="lead">Ingresa tus Credenciales para poder continuar :)</p>

                <br><br><br>

                <form class="col-lg-12"  METHOD="POST" ACTION="../Login_Controller">
                    <div class="input-group" style="width:340px;text-align:center;margin:0 auto;">
                        <input class="form-control input-lg" id="usuario" placeholder="Usuario" name ="usuario" type="text">
                    </div>
                    <div class="input-group" style="width:340px;text-align:center;margin:0 auto;">
                        <input class="form-control input-lg" id="contrasenia" placeholder="Contraseña" name ="contrasenia" type="text">
                    </div>
                    <div class="input-group" style="width:340px;text-align:center;margin:0 auto;">
                        <input class="form-control btn btn-primary " type="submit" id="entrar"  value="INGRESA! :)!">
                    </div>
                   
                </form>
            </div>

        </div> <!-- /row -->

        <div class="row">

            <div class="col-lg-12 text-center v-center" style="font-size:39pt;">
                <a><i class="icon-github"></i></a> <a href="#"><i class="icon-pinterest"></i></a>
            </div>

        </div>

        <br><br><br><br><br>

    </div> <!-- /container full -->

    <!-- script references -->
    <script src="../js/bootstrap/bootstrap.min.js"></script>
</body>
</body>
</html>
